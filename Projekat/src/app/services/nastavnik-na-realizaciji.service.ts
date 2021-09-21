import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NastavnikNaRealizaciji } from '../model/nastavnik-na-realizaciji';

@Injectable({
  providedIn: 'root'
})
export class NastavnikNaRealizacijiService {

  private base: string = "http://localhost:8080/api/nastavnikNaRealizaciji"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<NastavnikNaRealizaciji[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<NastavnikNaRealizaciji>(`${this.base}/${id}`);
  }

  create(NastavnikNaRealizaciji: NastavnikNaRealizaciji) {
    return this.httpClient.post<NastavnikNaRealizaciji>(this.base, NastavnikNaRealizaciji);
  }

  update(id: number, NastavnikNaRealizaciji: NastavnikNaRealizaciji) {
    return this.httpClient.put<NastavnikNaRealizaciji>(`${this.base}/${id}`, NastavnikNaRealizaciji);
  }

  delete(id: number) {
    return this.httpClient.delete<NastavnikNaRealizaciji>(`${this.base}/${id}`);
  }
}
