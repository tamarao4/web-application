import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RealizacijaPredmeta } from '../model/realizacija-predmeta';

@Injectable({
  providedIn: 'root'
})
export class RealizacijaPredmetaaService {
  private base: string = "http://localhost:8080/api/realizacijaPredmeta"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get< RealizacijaPredmeta[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get< RealizacijaPredmeta>(`${this.base}/${id}`);
  }

  create( realizacijaPredmeta:  RealizacijaPredmeta) {
    return this.httpClient.post< RealizacijaPredmeta>(this.base,  realizacijaPredmeta);
  }

  update(id: number,  realizacijaPredmeta:  RealizacijaPredmeta) {
    return this.httpClient.put< RealizacijaPredmeta>(`${this.base}/${id}`,  realizacijaPredmeta);
  }

  delete(id: number) {
    return this.httpClient.delete< RealizacijaPredmeta>(`${this.base}/${id}`);
  }
}
