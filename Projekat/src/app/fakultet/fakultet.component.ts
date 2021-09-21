import { UniverzitetService } from './../services/univerzitet.service';
import { AdresaService } from './../services/adresa.service';
import { NastavnikService } from './../services/nastavnik.service';
import { Adresa } from 'src/app/model/adresa';
import { Nastavnik } from 'src/app/model/nastavnik';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fakultet } from '../model/fakultet';
import { FakultetService } from '../services/fakultet.service';
import { Univerzitet } from '../model/univerzitet';

@Component({
  selector: 'app-fakultet',
  templateUrl: './fakultet.component.html',
  styleUrls: ['./fakultet.component.css']
})
export class FakultetComponent implements OnInit {
  nastavnik: Nastavnik [] = [];
  adresa: Adresa [] = [];
  univerzitet: Univerzitet [] = [];
  fakulteti: Fakultet [] = [];
  fakultetUpdate: Fakultet|null = null;
  
  constructor(private fakultetService: FakultetService, private router: Router, 
    private nastavnikService: NastavnikService, private adresaService: AdresaService,
    private univerzitetService: UniverzitetService) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
    this.getAll3();
    this.getAll4();
  }

  getAll2() {
    this.adresaService.getAll().subscribe((value) => {
      this.adresa = value;
    }, (error) => 
    console.log(error))
  }

  getAll3() {
    this.nastavnikService.getAll().subscribe((value) => {
      this.nastavnik = value;
    }, (error) => 
    console.log(error))
  }

  getAll4() {
    this.univerzitetService.getAll().subscribe((value) => {
      this.univerzitet = value;
    }, (error) => 
    console.log(error))
  }

  getAll() {
    this.fakultetService.getAll().subscribe((value) => {
      this.fakulteti = value; 
      debugger;
      console.log(this.fakulteti)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.fakultetService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(fakultet: Fakultet) {
    this.fakultetService.create(fakultet).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(fakultet: Fakultet) {
    if(this.fakultetUpdate && this.fakultetUpdate.id) {
      this.fakultetService.update(this.fakultetUpdate?.id, fakultet).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(fakultet: any) {
    this.fakultetUpdate = { ...fakultet };
  }

}
