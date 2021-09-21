import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { KljucneReci } from '../model/kljucne-reci';
import { KljucneReciService } from '../services/kljucne-reci.service';

@Component({
  selector: 'app-kljucne-reci',
  templateUrl: './kljucne-reci.component.html',
  styleUrls: ['./kljucne-reci.component.css']
})
export class KljucneReciComponent implements OnInit {
  kljucnereci: KljucneReci [] = [];
  kljucnereciUpdate: KljucneReci|null = null;
  
  constructor(private kljucnereciService: KljucneReciService,
    private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    
  }

  getAll() {
    this.kljucnereciService.getAll().subscribe((value) => {
      this.kljucnereci = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }
 
  delete(id: any) {
    this.kljucnereciService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(kljucnereci: KljucneReci) {
    this.kljucnereciService.create(kljucnereci).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(kljucnereci: KljucneReci) {
    if(this.kljucnereciUpdate && this.kljucnereciUpdate.id) {
      this.kljucnereciService.update(this.kljucnereciUpdate?.id, kljucnereci).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  
  setUpdate(kljucnereci: any) {
    this.kljucnereciUpdate = { ...kljucnereci };
  }

  prikaziDetalje(kljucnereci: KljucneReci) {
    this.router.navigate(["mesta", "/", {id: kljucnereci.id}])
  }

}
