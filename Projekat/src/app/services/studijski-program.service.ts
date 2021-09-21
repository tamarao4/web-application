import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StudijskiProgram } from '../model/studijski-program';

@Injectable({
  providedIn: 'root'
})
export class StudijskiProgramService {

  private base: string = "http://localhost:8080/api/studijskiprogrami"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get< StudijskiProgram[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get< StudijskiProgram>(`${this.base}/${id}`);
  }

  create( studijskiProgram:  StudijskiProgram) {
    return this.httpClient.post< StudijskiProgram>(this.base,  studijskiProgram);
  }

  update(id: number,  studijskiProgram:  StudijskiProgram) {
    return this.httpClient.put< StudijskiProgram>(`${this.base}/${id}`,  studijskiProgram);
  }

  delete(id: number) {
    return this.httpClient.delete< StudijskiProgram>(`${this.base}/${id}`);
  }
}
