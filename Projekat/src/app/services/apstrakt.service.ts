import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Apstrakt } from '../model/apstrakt';

@Injectable({
  providedIn: 'root'
})
export class  ApstraktService {
  private base: string = "http://localhost:8080/api/apstrakt"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get< Apstrakt[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Apstrakt>(`${this.base}/${id}`);
  }

  create(apstrakt: Apstrakt) {
    return this.httpClient.post<Apstrakt>(this.base, apstrakt);
  }

  update(id: number, apstrakt: Apstrakt) {
    return this.httpClient.put<Apstrakt>(`${this.base}/${id}`, apstrakt);
  }

  delete(id: number) {
    return this.httpClient.delete<Apstrakt>(`${this.base}/${id}`);
  }
}
