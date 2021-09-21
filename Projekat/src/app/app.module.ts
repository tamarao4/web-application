import { MestoFormComponent } from './mesto/mesto-form/mesto-form.component';
import { MestoComponent } from './mesto/mesto.component';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';

import { TipZvanjaComponent } from './tip-zvanja/tip-zvanja.component';
import { TipZvanjaFormComponent } from './tip-zvanja/tip-zvanja-form/tip-zvanja-form.component';
import { DrzavaComponent } from './drzava/drzava.component';
import { DrzavaFormaComponent } from './drzava/drzava-forma/drzava-forma.component';
import { AdresaComponent } from './adresa/adresa.component';
import { AdresaFormComponent } from './adresa/adresa-form/adresa-form.component';
import { TipNastaveComponent } from './tip-nastave/tip-nastave.component';
import { TipNastaveFormComponent } from './tip-nastave/tip-nastave-form/tip-nastave-form.component';
import { ZvanjeComponent } from './zvanje/zvanje.component';
import { ZvanjeFormComponent } from './zvanje/zvanje-form/zvanje-form.component';
import { ApstraktComponent } from './apstrakt/apstrakt.component';
import { ApstraktFormComponent } from './apstrakt/apstrakt-form/apstrakt-form.component';
import { AutoriComponent } from './autori/autori.component';
import { AutoriFormComponent } from './autori/autori-form/autori-form.component';
import { FakultetComponent } from './fakultet/fakultet.component';
import { FakultetFormComponent } from './fakultet/fakultet-form/fakultet-form.component';
import { GodinaStudijaComponent } from './godina-studija/godina-studija.component';
import { GodinaStudijaFormComponent } from './godina-studija/godina-studija-form/godina-studija-form.component';
import { IshodComponent } from './ishod/ishod.component';
import { IshodFormComponent } from './ishod/ishod-form/ishod-form.component';
import { KategorijaComponent } from './kategorija/kategorija.component';
import { KategorijaFormComponent } from './kategorija/kategorija-form/kategorija-form.component';
import { KorisnikComponent } from './korisnik/korisnik.component';
import { KorisnikFormComponent } from './korisnik/korisnik-form/korisnik-form.component';
import { KorisnikPravoPristupaComponent } from './korisnik-pravo-pristupa/korisnik-pravo-pristupa.component';
import { KorisnikPravoPristupaFormComponent } from './korisnik-pravo-pristupa/korisnik-pravo-pristupa-form/korisnik-pravo-pristupa-form.component';
import { NastavnikComponent } from './nastavnik/nastavnik.component';
import { NastavnikFormComponent } from './nastavnik/nastavnik-form/nastavnik-form.component';
import { NastavnikNaRealizacijiComponent } from './nastavnik-na-realizaciji/nastavnik-na-realizaciji.component';
import { NastavnikNaRealizacijiFormComponent } from './nastavnik-na-realizaciji/nastavnik-na-realizaciji-form/nastavnik-na-realizaciji-form.component';
import { NaucnaOblastComponent } from './naucna-oblast/naucna-oblast.component';
import { NaucnaOblastFormComponent } from './naucna-oblast/naucna-oblast-form/naucna-oblast-form.component';
import { NaucniRadComponent } from './naucni-rad/naucni-rad.component';
import { NaucniRadFormComponent } from './naucni-rad/naucni-rad-form/naucni-rad-form.component';
import { NregistrovaniKorisnikComponent } from './nregistrovani-korisnik/nregistrovani-korisnik.component';
import { NeregistrovaniKorisnikFormComponent } from './nregistrovani-korisnik/neregistrovani-korisnik-form/neregistrovani-korisnik-form.component';
import { ObjavljeniNaucniRadComponent } from './objavljeni-naucni-rad/objavljeni-naucni-rad.component';
import { ObjavljeniNaucniRadFormComponent } from './objavljeni-naucni-rad/objavljeni-naucni-rad-form/objavljeni-naucni-rad-form.component';
import { PohadjanjePredmetaComponent } from './pohadjanje-predmeta/pohadjanje-predmeta.component';
import { PohadjanjePredmetaFormComponent } from './pohadjanje-predmeta/pohadjanje-predmeta-form/pohadjanje-predmeta-form.component';
import { PravoPristupaComponent } from './pravo-pristupa/pravo-pristupa.component';
import { PravoPristupaFormComponent } from './pravo-pristupa/pravo-pristupa-form/pravo-pristupa-form.component';
import { PredmetComponent } from './predmet/predmet.component';
import { PredmetFormComponent } from './predmet/predmet-form/predmet-form.component';
import { RealizacijaPredmetaComponent } from './realizacija-predmeta/realizacija-predmeta.component';
import { RealizacijaPredmetaFormComponent } from './realizacija-predmeta/realizacija-predmeta-form/realizacija-predmeta-form.component';
import { StudentComponent } from './student/student.component';
import { StudentFormComponent } from './student/student-form/student-form.component';
import { StudentNaGodiniComponent } from './student-na-godini/student-na-godini.component';
import { StudentNaGodiniFormComponent } from './student-na-godini/student-na-godini-form/student-na-godini-form.component';
import { StudijskiProgramComponent } from './studijski-program/studijski-program.component';
import { StudijskiProgramFormComponent } from './studijski-program/studijski-program-form/studijski-program-form.component';
import { UniverzitetComponent } from './univerzitet/univerzitet.component';
import { UniverzitetFormComponent } from './univerzitet/univerzitet-form/univerzitet-form.component';
import { KljucneReciComponent } from './kljucne-reci/kljucne-reci.component';
import { KljucneReciFormComponent } from './kljucne-reci/kljucne-reci-form/kljucne-reci-form.component';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TipZvanjaComponent,
    TipZvanjaFormComponent,
    DrzavaComponent,
    DrzavaFormaComponent,
    AdresaComponent,
    AdresaFormComponent,
    TipNastaveComponent,
    TipNastaveFormComponent,
    MestoComponent,
    MestoFormComponent,
    ZvanjeComponent,
    ZvanjeFormComponent,
    ApstraktComponent,
    ApstraktFormComponent,
    AutoriComponent,
    AutoriFormComponent,
    FakultetComponent,
    FakultetFormComponent,
    GodinaStudijaComponent,
    GodinaStudijaFormComponent,
    IshodComponent,
    IshodFormComponent,
    KategorijaComponent,
    KategorijaFormComponent,
    KorisnikComponent,
    KorisnikFormComponent,
    KorisnikPravoPristupaComponent,
    KorisnikPravoPristupaFormComponent,
    NastavnikComponent,
    NastavnikFormComponent,
    NastavnikNaRealizacijiComponent,
    NastavnikNaRealizacijiFormComponent,
    NaucnaOblastComponent,
    NaucnaOblastFormComponent,
    NaucniRadComponent,
    NaucniRadFormComponent,
    NregistrovaniKorisnikComponent,
    NeregistrovaniKorisnikFormComponent,
    ObjavljeniNaucniRadComponent,
    ObjavljeniNaucniRadFormComponent,
    PohadjanjePredmetaComponent,
    PohadjanjePredmetaFormComponent,
    PravoPristupaComponent,
    PravoPristupaFormComponent,
    PredmetComponent,
    PredmetFormComponent,
    RealizacijaPredmetaComponent,
    RealizacijaPredmetaFormComponent,
    StudentComponent,
    StudentFormComponent,
    StudentNaGodiniComponent,
    StudentNaGodiniFormComponent,
    StudijskiProgramComponent,
    StudijskiProgramFormComponent,
    UniverzitetComponent,
    UniverzitetFormComponent,
    KljucneReciComponent,
    KljucneReciFormComponent 
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
