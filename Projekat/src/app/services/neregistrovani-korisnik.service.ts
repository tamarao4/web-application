import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NeregistrovaniKorisnik } from '../model/neregistrovani-korisnik';

@Injectable({
  providedIn: 'root'
})
export class NeregistrovaniKorisnikService {

  private base: string = "http://localhost:8080/api/neregistrovani"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<  NeregistrovaniKorisnik[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<  NeregistrovaniKorisnik>(`${this.base}/${id}`);
  }

  create(  neregistrovaniKorisnik:   NeregistrovaniKorisnik) {
    return this.httpClient.post<  NeregistrovaniKorisnik>(this.base,   neregistrovaniKorisnik);
  }

  update(id: number,   neregistrovaniKorisnik:   NeregistrovaniKorisnik) {
    return this.httpClient.put<  NeregistrovaniKorisnik>(`${this.base}/${id}`,   neregistrovaniKorisnik);
  }

  delete(id: number) {
    return this.httpClient.delete<  NeregistrovaniKorisnik>(`${this.base}/${id}`);
  }
}
