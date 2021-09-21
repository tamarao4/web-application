import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Korisnik } from '../model/korisnik';

@Injectable({
  providedIn: 'root'
})
export class KorisnikService {

 
  private base: string = "http://localhost:8080/api/kk"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Korisnik[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Korisnik>(`${this.base}/${id}`);
  }

  create(Korisnik: Korisnik) {
    return this.httpClient.post<Korisnik>(this.base, Korisnik);
  }

  update(id: number, Korisnik: Korisnik) {
    return this.httpClient.put<Korisnik>(`${this.base}/${id}`, Korisnik);
  }

  delete(id: number) {
    return this.httpClient.delete<Korisnik>(`${this.base}/${id}`);
  }
}
