import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Drzava } from '../model/drzava';
import { DrzavaService } from '../services/drzava.service';

@Component({
  selector: 'app-drzava',
  templateUrl: './drzava.component.html',
  styleUrls: ['./drzava.component.css']
})
export class DrzavaComponent implements OnInit {
 
  drzava: Drzava [] = [];
  drzavaUpdate: Drzava|null = null;
  
  constructor( private drzavaService: DrzavaService, 
    private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    
  }


  getAll() {
    this.drzavaService.getAll().subscribe((value) => {
      this.drzava = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.drzavaService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(drzava: Drzava) {
    this.drzavaService.create(drzava).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(drzava: Drzava) {
    if(this.drzavaUpdate && this.drzavaUpdate.id) {
      this.drzavaService.update(this.drzavaUpdate?.id, drzava).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(drzava: any) {
    this.drzavaUpdate = { ...drzava };
  }

  prikaziDetalje(drzava: Drzava) {
    this.router.navigate(["drzava", "/", {id: drzava.id}])
  }

}
