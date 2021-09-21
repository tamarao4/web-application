import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PravoPristupa } from '../model/pravo-pristupa';

@Injectable({
  providedIn: 'root'
})
export class PravoPristupaService {

  private base: string = "http://localhost:8080/api/PravoPristupa"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<PravoPristupa[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<PravoPristupa>(`${this.base}/${id}`);
  }

  create(pravoPristupa: PravoPristupa) {
    return this.httpClient.post<PravoPristupa>(this.base, pravoPristupa);
  }

  update(id: number, pravoPristupa: PravoPristupa) {
    return this.httpClient.put<PravoPristupa>(`${this.base}/${id}`, pravoPristupa);
  }

  delete(id: number) {
    return this.httpClient.delete<PravoPristupa>(`${this.base}/${id}`);
  }
}
