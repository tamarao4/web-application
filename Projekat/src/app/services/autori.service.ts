import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Autor } from '../model/autor';

@Injectable({
  providedIn: 'root'
})

export class AutoriService {

  private base: string = "http://localhost:8080/api/autori"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Autor[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<Autor>(`${this.base}/${id}`);
  }

  create(Autor: Autor) {
    return this.httpClient.post<Autor>(this.base, Autor);
  }

  update(id: number, Autor: Autor) {
    return this.httpClient.put<Autor>(`${this.base}/${id}`, Autor);
  }

  delete(id: number) {
    return this.httpClient.delete<Autor>(`${this.base}/${id}`);
  }
}

