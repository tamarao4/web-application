import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NaucniRad } from '../model/naucni-rad';

@Injectable({
  providedIn: 'root'
})
export class NaucniRadService {

  
  private base: string = "http://localhost:8080/api/naucniRad"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<NaucniRad[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get<NaucniRad>(`${this.base}/${id}`);
  }

  create( naucniRad:  NaucniRad) {
    return this.httpClient.post< NaucniRad>(this.base,  naucniRad);
  }

  update(id: number,  naucniRad:  NaucniRad) {
    return this.httpClient.put< NaucniRad>(`${this.base}/${id}`,  naucniRad);
  }

  delete(id: number) {
    return this.httpClient.delete< NaucniRad>(`${this.base}/${id}`);
  }
}
