import { ObjavljeniNaucniRadService } from './../services/objavljeni-naucni-rad.service';
import { AdresaService } from './../services/adresa.service';
import { ObjavljeniNaucniRad } from './../model/objavljeni-naucni-rad';
import { Adresa } from 'src/app/model/adresa';
import { Component, OnInit } from '@angular/core';
import { Nastavnik } from '../model/nastavnik';
import { Router } from '@angular/router';
import { NastavnikService } from '../services/nastavnik.service';

@Component({
  selector: 'app-nastavnik',
  templateUrl: './nastavnik.component.html',
  styleUrls: ['./nastavnik.component.css']
})
export class NastavnikComponent implements OnInit {

  adresa: Adresa [] = [];
  objavljeniNaucniRad: ObjavljeniNaucniRad [] = [];

  nastavnik: Nastavnik[] = [];
  nastavnikUpdate: Nastavnik|null = null;

  constructor(private adresaService: AdresaService, 
    private router: Router, private objavljeniNaucniRadService: ObjavljeniNaucniRadService, 
    private nastavnikService: NastavnikService) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
    this.getAll3();
  }

  getAll2() {
    this.adresaService.getAll().subscribe((value) => {
      this.adresa = value;
    }, (error) => {
      console.log(error);
    });
  }

  getAll3() {
    this.objavljeniNaucniRadService.getAll().subscribe((value) => {
      this.objavljeniNaucniRad = value;
    }, (error) => {
      console.log(error);
    });
  }

  getAll() {
    this.nastavnikService.getAll().subscribe((value) => {
      this.nastavnik = value;
    }, (error) => {
      console.log(error);
    });
  }

  delete(id: any) {
    this.nastavnikService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(nastavnik: Nastavnik) {
    this.nastavnikService.create(nastavnik).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(nastavnik: Nastavnik) {
    if(this.nastavnikUpdate && this.nastavnikUpdate.id) {
      this.nastavnikService.update(this.nastavnikUpdate?.id, nastavnik).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }    
  }

  setUpdate(nastavnik: any) {
    this.nastavnikUpdate = { ...nastavnik };
  }


}
