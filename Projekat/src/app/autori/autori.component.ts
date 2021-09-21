import { Student } from './../model/student';
import { NeregistrovaniKorisnik } from './../model/neregistrovani-korisnik';
import { NaucniRad } from './../model/naucni-rad';
import { Component, OnInit } from '@angular/core';
import { Nastavnik } from '../model/nastavnik';
import { TipZvanjaService } from '../services/tip-zvanja.service';
import { NaucnaOblastService } from '../services/naucna-oblast.service';
import { AutoriService } from '../services/autori.service';
import { Router } from '@angular/router';
import { TipZvanja } from '../model/tip-zvanja';
import { NastavnikService } from '../services/nastavnik.service';
import { NaucniRadService } from '../services/naucni-rad.service';
import { NeregistrovaniKorisnikService } from '../services/neregistrovani-korisnik.service';
import { StudentService } from '../services/student.service';
import { Autor } from '../model/autor';

@Component({
  selector: 'app-autori',
  templateUrl: './autori.component.html',
  styleUrls: ['./autori.component.css']
})
export class AutoriComponent implements OnInit {
  autor: Autor [] = [];
  naucniRad: NaucniRad [] = [];
  neregistrovaniKorisnik: NeregistrovaniKorisnik [] = [];    
  nastavnik: Nastavnik [] = [];
  student: Student[] =[];
  
  autorUpdate: Autor|null = null;
  
  constructor( private naucniRadService: NaucniRadService, private neregistrovaniKorisnikService: NeregistrovaniKorisnikService,
    private nastavnikService: NastavnikService, private studentService: StudentService, private autorService: AutoriService, 
    private router: Router) { }

  ngOnInit(): void {
    this.getAll();
    this.getAll2();
    this.getAll3();
    this.getAll4();
    this.getAll4();
    
  }

  getAll2() {
    this.naucniRadService.getAll().subscribe((value) => {
      this.naucniRad = value;
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
    this.neregistrovaniKorisnikService.getAll().subscribe((value) => {
      this.neregistrovaniKorisnik = value;
      console.log(value)
    }, (error) => {
      console.log(error);
    });
  }

  getAll5() {
    this.studentService.getAll().subscribe((value) => {
      this.student = value;
      console.log(value)
    }, (error) => {
      console.log(error);
    });
  }

  getAll() {
    this.autorService.getAll().subscribe((value) => {
      this.autor = value;
      console.log(value)
    }, (error) => 
    console.log(error))
  }

  delete(id: any) {
    this.autorService.delete(id).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  create(autor: Autor) {
    this.autorService.create(autor).subscribe((value) => {
      this.getAll();
    }, (error) => {
      console.log(error);
    })
  }

  update(autor: Autor) {
    if(this.autorUpdate && this.autorUpdate.id) {
      this.autorService.update(this.autorUpdate?.id, autor).subscribe((value) => {
        this.getAll();
      }, (error) => {
        console.log(error);
      })
    }
      
    }
  

  setUpdate(tipZvanja: any) {
    this.autorUpdate = { ...tipZvanja };
  }

  prikaziDetalje(tipZvanja: TipZvanja) {
    this.router.navigate(["tipautor", "/", {id: tipZvanja.id}])
  }
}
