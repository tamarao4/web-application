import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Kategorija } from '../model/kategorija';

@Injectable({
  providedIn: 'root'
})
export class KategorijaService {

  private base: string = "http://localhost:8080/api/kategorija"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Kategorija[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Kategorija>(`${this.base}/${id}`);
  }

  create(kategorija: Kategorija) {
    return this.httpClient.post<Kategorija>(this.base, kategorija);
  }

  update(id: number, kategorija: Kategorija) {
    return this.httpClient.put<Kategorija>(`${this.base}/${id}`, kategorija);
  }

  delete(id: number) {
    return this.httpClient.delete<Kategorija>(`${this.base}/${id}`);
  }
}
