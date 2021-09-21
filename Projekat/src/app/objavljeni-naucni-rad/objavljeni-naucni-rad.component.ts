import { ObjavljeniNaucniRadService } from './../services/objavljeni-naucni-rad.service';
import { NaucniRadService } from './../services/naucni-rad.service';
import { ObjavljeniNaucniRad } from './../model/objavljeni-naucni-rad';
import { Component, OnInit } from '@angular/core';
import { NaucniRad } from '../model/naucni-rad';
import { Router } from '@angular/router';

@Component({
  selector: 'app-objavljeni-naucni-rad',
  templateUrl: './objavljeni-naucni-rad.component.html',
  styleUrls: ['./objavljeni-naucni-rad.component.css']
})
export class ObjavljeniNaucniRadComponent implements OnInit {
  naucniRad: NaucniRad [] = [];
  objavljeniNaucniRad: ObjavljeniNaucniRad [] = [];
  objavljeniNaucniRadUpdate: ObjavljeniNaucniRad|null = null;
  
  constructor(private naucniRadService: NaucniRadService, private objavljeniNaucniRadService: ObjavljeniNaucniRadService,
    private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
    
  }

  getAll() {
    this.objavljeniNaucniRadService.getAll().subscribe((value) => {
      this.objavljeniNaucniRad = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }
  getAll2() {
    this.naucniRadService.getAll().subscribe((value) => {
      this.naucniRad = value;
      console.log(value)
    }, (error) => {
      console.log(error);
    });
  }

  delete(id: any) {
    this.objavljeniNaucniRadService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(mesto: ObjavljeniNaucniRad) {
    this.objavljeniNaucniRadService.create(mesto).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(mesto: ObjavljeniNaucniRad) {
    if(this.objavljeniNaucniRadUpdate && this.objavljeniNaucniRadUpdate.id) {
      this.objavljeniNaucniRadService.update(this.objavljeniNaucniRadUpdate?.id, mesto).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  
  setUpdate(mesto: any) {
    this.objavljeniNaucniRadUpdate = { ...mesto };
  }

}
