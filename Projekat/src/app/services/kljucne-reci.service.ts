import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { KljucneReci } from '../model/kljucne-reci';

@Injectable({
  providedIn: 'root'
})
export class KljucneReciService {

  private base: string = "http://localhost:8080/api/kljucneReci"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<KljucneReci[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<KljucneReci>(`${this.base}/${id}`);
  }

  create(kljucneReci: KljucneReci) {
    return this.httpClient.post<KljucneReci>(this.base, kljucneReci);
  }

  update(id: number, kljucneReci: KljucneReci) {
    return this.httpClient.put<KljucneReci>(`${this.base}/${id}`, kljucneReci);
  }

  delete(id: number) {
    return this.httpClient.delete<KljucneReci>(`${this.base}/${id}`);
  }
}
