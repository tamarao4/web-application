import { Zvanje } from './../model/zvanje';
import { NaucnaOblastService } from './../services/naucna-oblast.service';
import { NastavnikService } from './../services/nastavnik.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TipZvanja } from '../model/tip-zvanja';
import { TipZvanjaService } from '../services/tip-zvanja.service';
import { ZvanjeService } from '../services/zvanje.service';
import { Nastavnik } from '../model/nastavnik';
import { NaucnaOblast } from '../model/naucna-oblast';

@Component({
  selector: 'app-zvanje',
  templateUrl: './zvanje.component.html',
  styleUrls: ['./zvanje.component.css']
})
export class ZvanjeComponent implements OnInit {
  tipZvanja: TipZvanja [] = [];
  zvanje: Zvanje [] = [];    
  nastavnik: Nastavnik [] = [];
  naucnaOblast: NaucnaOblast[] =[];
  
  zvanjaUpdate: TipZvanja|null = null;
  
  constructor( private tipZvanjaService: TipZvanjaService, private nastavnikService: NastavnikService,
    private naucnaOblastService: NaucnaOblastService, private zvanjeService: ZvanjeService, private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
    this.getAll3();
    this.getAll4();
    
  }

  getAll2() {
    this.tipZvanjaService.getAll().subscribe((value) => {
      this.tipZvanja = value;
      console.log(value)
    }, (error) => {
      console.log(error);
    });
  }
  getAll3() {
    this.nastavnikService.getAll().subscribe((value) => {
      this.nastavnik = value;
      console.log(value)
    }, (error) => {
      console.log(error);
    });
  }
  getAll4() {
    this.naucnaOblastService.getAll().subscribe((value) => {
      this.naucnaOblast = value;
      console.log(value)
    }, (error) => {
      console.log(error);
    });
  }

  // dodati get all za nastavnika i  anucnu oblast

  getAll() {
    this.zvanjeService.getAll().subscribe((value) => {
      this.zvanje = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.zvanjeService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(zvanje: Zvanje) {
    this.zvanjeService.create(zvanje).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(zvanje: Zvanje) {
    if(this.zvanjaUpdate && this.zvanjaUpdate.id) {
      this.zvanjeService.update(this.zvanjaUpdate?.id, zvanje).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(zvanje: any) {
    this.zvanjaUpdate = { ...zvanje };
  }


}
