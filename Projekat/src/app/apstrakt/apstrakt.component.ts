import { NaucniRad } from './../model/naucni-rad';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApstraktService } from '../services/apstrakt.service';
import { Apstrakt } from '../model/apstrakt';
import { NaucniRadService } from '../services/naucni-rad.service';

@Component({
  selector: 'app-apstrakt',
  templateUrl: './apstrakt.component.html',
  styleUrls: ['./apstrakt.component.css']
})
export class ApstraktComponent implements OnInit {

  naucniRad: NaucniRad[] = [];
  apstrakt: Apstrakt [] = [];
  apstraktUpdate: Apstrakt|null = null;

  constructor(private apstraktService: ApstraktService, private naucniRadService: NaucniRadService, private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();

  }


  getAll() {
    this.apstraktService.getAll().subscribe((value) => {
      this.apstrakt = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }
  getAll2() {
    this.naucniRadService.getAll().subscribe((value) => {
      this.naucniRad = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.apstraktService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(apstrakt: Apstrakt) {
    this.apstraktService.create(apstrakt).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(apstrakt: Apstrakt) {
    if(this.apstraktUpdate && this.apstraktUpdate.id) {
      this.apstraktService.update(this.apstraktUpdate?.id, apstrakt).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(apstrakt: any) {
    this.apstraktUpdate = { ...apstrakt };
  }

}
