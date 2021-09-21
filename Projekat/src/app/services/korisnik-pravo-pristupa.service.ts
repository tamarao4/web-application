import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KorisnikPravoPristupa } from '../model/korisnik-pravo-pristupa';

@Injectable({
  providedIn: 'root'
})
export class KorisnikPravoPristupaService {

  
  private base: string = "http://localhost:8080/api/KorisnikPravoPristupa"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<KorisnikPravoPristupa[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<KorisnikPravoPristupa>(`${this.base}/${id}`);
  }

  create(KorisnikPravoPristupa: KorisnikPravoPristupa) {
    return this.httpClient.post<KorisnikPravoPristupa>(this.base, KorisnikPravoPristupa);
  }

  update(id: number, KorisnikPravoPristupa: KorisnikPravoPristupa) {
    return this.httpClient.put<KorisnikPravoPristupa>(`${this.base}/${id}`, KorisnikPravoPristupa);
  }

  delete(id: number) {
    return this.httpClient.delete<KorisnikPravoPristupa>(`${this.base}/${id}`);
  }
}
