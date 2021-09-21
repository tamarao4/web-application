import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Drzava } from '../model/drzava';

@Injectable({
  providedIn: 'root'
})
export class DrzavaService {
  private base: string = "http://localhost:8080/api/drzave"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Drzava[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Drzava>(`${this.base}/${id}`);
  }

  create(tipZvanja: Drzava) {
    return this.httpClient.post<Drzava>(this.base, tipZvanja);
  }

  update(id: number, tipZvanja: Drzava) {
    return this.httpClient.put<Drzava>(`${this.base}/${id}`, tipZvanja);
  }

  delete(id: number) {
    return this.httpClient.delete<Drzava>(`${this.base}/${id}`);
  }
}
