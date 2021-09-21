import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NaucnaOblast } from '../model/naucna-oblast';

@Injectable({
  providedIn: 'root'
})
export class NaucnaOblastService {

  private base: string = "http://localhost:8080/api/naucne_oblasti"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get< NaucnaOblast[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get< NaucnaOblast>(`${this.base}/${id}`);
  }

  create( NaucnaOblast:  NaucnaOblast) {
    return this.httpClient.post< NaucnaOblast>(this.base,  NaucnaOblast);
  }

  update(id: number,  NaucnaOblast:  NaucnaOblast) {
    return this.httpClient.put< NaucnaOblast>(`${this.base}/${id}`,  NaucnaOblast);
  }

  delete(id: number) {
    return this.httpClient.delete< NaucnaOblast>(`${this.base}/${id}`);
  }
}
