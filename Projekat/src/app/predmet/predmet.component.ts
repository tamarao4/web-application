import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Predmet } from '../model/predmet';
import { PredmetService } from '../services/predmet.service';

@Component({
  selector: 'app-predmet',
  templateUrl: './predmet.component.html',
  styleUrls: ['./predmet.component.css']
})
export class PredmetComponent implements OnInit {

  // godinaStudija: GodinaStudija [] = [];
  // pohadjanjePredmeta: PohadjanjePredmeta[] = []

  predmeti: Predmet [] = [];
  predmetUpdate: Predmet|null = null;
  
  constructor(private predmetService: PredmetService, private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    // this.getAll2();
    // this.getAll3();
  }

  // getAll3() {
  //   this.godinaStudijaService.getAll().subscribe((value) => {
  //     this.godinaStudija = value;
  //   }, (error) => 
  //   console.log(error))
  // }

  // getAll2() {
  //   this.pohadjanjePredmetaService.getAll().subscribe((value) => {
  //     this.pohadjanjePredmeta = value;
  //   }, (error) => 
  //   console.log(error))
  // }

  getAll() {
    this.predmetService.getAll().subscribe((value) => {
      this.predmeti = value; 
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.predmetService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(predmet: Predmet) {
    this.predmetService.create(predmet).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(predmet: Predmet) {
    if(this.predmetUpdate && this.predmetUpdate.id) {
      this.predmetService.update(this.predmetUpdate?.id, predmet).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  
  setUpdate(predmet: any) {
    this.predmetUpdate = { ...predmet };
  }
}
