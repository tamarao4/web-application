import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NastavnikNaRealizaciji } from '../model/nastavnik-na-realizaciji';
import { NastavnikNaRealizacijiService } from '../services/nastavnik-na-realizaciji.service';

@Component({
  selector: 'app-nastavnik-na-realizaciji',
  templateUrl: './nastavnik-na-realizaciji.component.html',
  styleUrls: ['./nastavnik-na-realizaciji.component.css']
})
export class NastavnikNaRealizacijiComponent implements OnInit {
  nastavniciNaRealizaciji: NastavnikNaRealizaciji [] = [];
  nastavniciNaRealizacijiUpdate: NastavnikNaRealizaciji|null = null;
  
  constructor(private nastavnikNaRealizacijiService: NastavnikNaRealizacijiService, private router: Router) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.nastavnikNaRealizacijiService.getAll().subscribe((value) => {
      this.nastavniciNaRealizaciji = value; 
      console.log(this.nastavniciNaRealizaciji)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.nastavnikNaRealizacijiService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(nastavnikNaRealizaciji: NastavnikNaRealizaciji) {
    this.nastavnikNaRealizacijiService.create(nastavnikNaRealizaciji).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(nastavnikNaRealizaciji: NastavnikNaRealizaciji) {
    if(this.nastavniciNaRealizacijiUpdate && this.nastavniciNaRealizacijiUpdate.id) {
      this.nastavnikNaRealizacijiService.update(this.nastavniciNaRealizacijiUpdate?.id, nastavnikNaRealizaciji).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(nastavnikNaRealizaciji: any) {
    this.nastavniciNaRealizacijiUpdate = { ...nastavnikNaRealizaciji };
  }

  prikaziDetalje(nastavnikNaRealizaciji: NastavnikNaRealizaciji) {
    this.router.navigate(["nastavnicinarealizaciji", "/", {id: nastavnikNaRealizaciji.id}])
  }

}
