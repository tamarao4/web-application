import { KljucneReciComponent } from './kljucne-reci/kljucne-reci.component';
import { ApstraktComponent } from './apstrakt/apstrakt.component';
import { MestoComponent } from './mesto/mesto.component';
import { ZvanjeComponent } from './zvanje/zvanje.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdresaComponent } from './adresa/adresa.component';
import { DrzavaComponent } from './drzava/drzava.component';
import { HomeComponent } from './home/home.component';


import { TipNastaveComponent } from './tip-nastave/tip-nastave.component';

import { TipZvanjaComponent } from './tip-zvanja/tip-zvanja.component';
import { AutoriComponent } from './autori/autori.component';
import { FakultetComponent } from './fakultet/fakultet.component';
import { GodinaStudijaComponent } from './godina-studija/godina-studija.component';
import { IshodComponent } from './ishod/ishod.component';
import { KorisnikPravoPristupaComponent } from './korisnik-pravo-pristupa/korisnik-pravo-pristupa.component';
import { KorisnikComponent } from './korisnik/korisnik.component';
import { NastavnikNaRealizacijiComponent } from './nastavnik-na-realizaciji/nastavnik-na-realizaciji.component';
import { NastavnikComponent } from './nastavnik/nastavnik.component';
import { NaucnaOblastComponent } from './naucna-oblast/naucna-oblast.component';
import { NaucniRadComponent } from './naucni-rad/naucni-rad.component';
import { ObjavljeniNaucniRadComponent } from './objavljeni-naucni-rad/objavljeni-naucni-rad.component';
import { PohadjanjePredmetaComponent } from './pohadjanje-predmeta/pohadjanje-predmeta.component';
import { PredmetComponent } from './predmet/predmet.component';
import { RealizacijaPredmetaComponent } from './realizacija-predmeta/realizacija-predmeta.component';
import { StudentNaGodiniComponent } from './student-na-godini/student-na-godini.component';
import { StudentComponent } from './student/student.component';
import { StudijskiProgramComponent } from './studijski-program/studijski-program.component';
import { UniverzitetComponent } from './univerzitet/univerzitet.component';

const routes: Routes = [
  { path: "home", component: HomeComponent },
  { path: "pohadjanjepredmeta", component: PohadjanjePredmetaComponent },
  { path: "nastavnicinarealizaciji", component: NastavnikNaRealizacijiComponent },
  { path: "tipovinastave", component: TipNastaveComponent },
  { path: "studentinagodini", component: StudentNaGodiniComponent },
  { path: "godinestudija", component: GodinaStudijaComponent },
  { path: "zvanja", component: ZvanjeComponent },
  { path: "tipzvanja", component: TipZvanjaComponent },
  { path: "naucneoblasti", component: NaucnaOblastComponent },
  { path: "nastavnici", component: NastavnikComponent },
  { path: "univerziteti", component: UniverzitetComponent },
  { path: "fakulteti", component: FakultetComponent },
  { path: "studenti", component: StudentComponent },
  { path: "studijski_programi", component: StudijskiProgramComponent },
  { path: "mesta", component: MestoComponent },
  { path: "adrese", component: AdresaComponent },
  { path: "apstrakt", component: ApstraktComponent },
  { path: "autori", component: AutoriComponent },
  { path: "drzava", component: DrzavaComponent },
  { path: "ishod", component: IshodComponent },
  { path: "kategorije", component: AdresaComponent },
  { path: "korisnik", component: KorisnikComponent },
  { path: "korisnikPravoPristupa", component: KorisnikPravoPristupaComponent },
  { path: "nastavnik", component: NastavnikComponent },
  { path: "naucnaoblast", component: NaucnaOblastComponent },
  { path: "naucnirad", component: NaucniRadComponent },
  { path: "objavljeninaucnirad", component: ObjavljeniNaucniRadComponent },
  { path: "pohadjanjepredmeta", component: PohadjanjePredmetaComponent },
  { path: "realizacijapredmeta", component: RealizacijaPredmetaComponent },
  { path: "studijskiprogram", component: StudijskiProgramComponent },
  { path: "predmeti", component: PredmetComponent },
  { path: "kljucnereci", component: KljucneReciComponent},
  { path: "naucnaoblast", component: NaucnaOblastComponent},
  
  { path: "objavljeninaucnirad", component: ObjavljeniNaucniRadComponent},
  
  { path: "studijskiprogram", component: ObjavljeniNaucniRadComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
