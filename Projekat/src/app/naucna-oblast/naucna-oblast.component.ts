import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NaucnaOblast } from '../model/naucna-oblast';
import { NaucnaOblastService } from '../services/naucna-oblast.service';

@Component({
  selector: 'app-naucna-oblast',
  templateUrl: './naucna-oblast.component.html',
  styleUrls: ['./naucna-oblast.component.css']
})
export class NaucnaOblastComponent implements OnInit {

  naucnaOblast: NaucnaOblast[] = [];
  naucnaOblastUpdate: NaucnaOblast|null = null;
  
  constructor(private naucnaOblastService: NaucnaOblastService, 
    private router: Router) { }

  ngOnInit(): void {
    this.getAll();
  }


  getAll() {
    this.naucnaOblastService.getAll().subscribe((value) => {
      this.naucnaOblast = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.naucnaOblastService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(naucnaOblast: NaucnaOblast) {
    this.naucnaOblastService.create(naucnaOblast).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(naucnaOblast: NaucnaOblast) {
    if(this.naucnaOblastUpdate && this.naucnaOblastUpdate.id) {
      this.naucnaOblastService.update(this.naucnaOblastUpdate?.id, naucnaOblast).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(naucnaOblast: NaucnaOblast) {
    this.naucnaOblastUpdate = { ...naucnaOblast };
  }

  prikaziDetalje(naucnaOblast: NaucnaOblast) {
    this.router.navigate(["naucneoblasti", "/", {id: naucnaOblast.id}])
  }
}
