import { Mesto } from 'src/app/model/mesto';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Adresa } from '../model/adresa';
import { AdresaService } from '../services/adresa.service';
import { MestoService } from '../services/mesto.service';

@Component({
  selector: 'app-adresa',
  templateUrl: './adresa.component.html',
  styleUrls: ['./adresa.component.css']
})
export class AdresaComponent implements OnInit {
  mesto: Mesto [] = [];
  adrese: Adresa [] = [];
  adresaUpdate: Adresa|null = null;

  constructor(private mestoService: MestoService, private adresaService: AdresaService, private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
  }


  getAll() {
    this.adresaService.getAll().subscribe((value) => {
      this.adrese = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }
  getAll2() {
    this.mestoService.getAll().subscribe((value) => {
      this.mesto = value;
      console.log(value)
    }, (error) => {
      console.log(error);
    });
  }

  delete(id: any) {
    this.adresaService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(adrese: Adresa) {
    this.adresaService.create(adrese).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(adrese: Adresa) {
    if(this.adresaUpdate && this.adresaUpdate.id) {
      this.adresaService.update(this.adresaUpdate?.id, adrese).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(adrese: any) {
    this.adresaUpdate = { ...adrese };
  }

}
