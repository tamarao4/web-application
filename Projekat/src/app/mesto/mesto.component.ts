import { DrzavaService } from './../services/drzava.service';
import { Drzava } from 'src/app/model/drzava';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Mesto } from '../model/mesto';
import { MestoService } from '../services/mesto.service';

@Component({
  selector: 'app-mesto',
  templateUrl: './mesto.component.html',
  styleUrls: ['./mesto.component.css']
})
export class MestoComponent implements OnInit {
  drzava: Drzava [] = [];
  mesto: Mesto [] = [];
  mestoUpdate: Mesto|null = null;
  
  constructor(private drzavaService: DrzavaService, private mestoService: MestoService,
    private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
    
  }

  getAll() {
    this.mestoService.getAll().subscribe((value) => {
      this.mesto = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }
  getAll2() {
    this.drzavaService.getAll().subscribe((value) => {
      this.drzava = value;
      console.log(value)
    }, (error) => {
      console.log(error);
    });
  }

  delete(id: any) {
    this.mestoService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(mesto: Mesto) {
    this.mestoService.create(mesto).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(mesto: Mesto) {
    if(this.mestoUpdate && this.mestoUpdate.id) {
      this.mestoService.update(this.mestoUpdate?.id, mesto).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  
  setUpdate(mesto: any) {
    this.mestoUpdate = { ...mesto };
  }

  prikaziDetalje(mesto: Mesto) {
    this.router.navigate(["mesta", "/", {id: mesto.id}])
  }
}
