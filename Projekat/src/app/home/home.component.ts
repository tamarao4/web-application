import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  
  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
  }
  tipZvanja(){
    this.router.navigate(["tipzvanja"]);
  }
  drzava(){
    this.router.navigate(["drzave"]);
  }
  adresa(){
    this.router.navigate(["adrese"]);
  }
  autori(){
    this.router.navigate(["autori"]);
  }
  apstrakt(){
    this.router.navigate(["apstrakt"]);
  }


  tipNastave(){
    this.router.navigate(["tipovinastave"]);
  }

  mesto() {
    this.router.navigate(["mesta"]);
  }


  zvanje() {
    this.router.navigate(["zvanja"]);
  }

  univerziteti() {
    this.router.navigate(["univerziteti"]);
  }

  fakulteti() {
    this.router.navigate(["fakulteti"]);
  }

  studenti() {
    this.router.navigate(["studenti"]);
  }

  studijskiProgram(){
    this.router.navigate(["studijski_programi"]);
  }


  predmet(){
    this.router.navigate(["predmeti"]);
  }

  ishod(){
    this.router.navigate(["ishod"]);
  }

  kategorija(){
    this.router.navigate(["kategorija"]);
  }

  nastavniknarealizaciji(){
    this.router.navigate(["nastavniknarealizaciji"]);
  }

  naucnirad(){
    this.router.navigate(["naucnirad"]);
  }


  objavljeninaucnirad(){
  this.router.navigate(["objavljeninaucnirad"]);
  }


  pohadjanjePredmeta(){
    this.router.navigate(["pohadjanjepredmeta"]);
  }

  nastavnikNaRealizaciji(){
    this.router.navigate(["nastavnicinarealizaciji"]);
  }


  studentNaGodini(){
    this.router.navigate(["studentinagodini"]);
  }

  godinaStudija(){
    this.router.navigate(["godinestudija"]);
  }



  naucnaOblast(){
    this.router.navigate(["naucneoblasti"]);
  }

  nastavnik(){
    this.router.navigate(["nastavnici"]);
  }

  kljucnereci(){
    this.router.navigate(["kljucnereci"]);
  }

  naucnaoblast(){
    this.router.navigate(["naucnaoblast"]);
  }

}