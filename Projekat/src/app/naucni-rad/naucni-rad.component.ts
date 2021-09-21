import { NaucniRadService } from './../services/naucni-rad.service';
import { NaucniRad } from './../model/naucni-rad';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-naucni-rad',
  templateUrl: './naucni-rad.component.html',
  styleUrls: ['./naucni-rad.component.css']
})
export class NaucniRadComponent implements OnInit {
  naucniRad: NaucniRad [] = [];
  naucniRadUpdate: NaucniRad|null = null;
  
  constructor( private naucniRadService: NaucniRadService,
    private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    
  }

  getAll() {
    this.naucniRadService.getAll().subscribe((value) => {
      this.naucniRad = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }


  delete(id: any) {
    this.naucniRadService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(naucniRad: NaucniRad) {
    this.naucniRadService.create(naucniRad).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(naucniRad: NaucniRad) {
    if(this.naucniRadUpdate && this.naucniRadUpdate.id) {
      this.naucniRadService.update(this.naucniRadUpdate?.id, naucniRad).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  
  setUpdate(naucniRad: any) {
    this.naucniRadUpdate = { ...naucniRad };
  }

  prikaziDetalje(naucniRad: NaucniRad) {
    this.router.navigate(["mesta", "/", {id: naucniRad.id}])
  }

}
