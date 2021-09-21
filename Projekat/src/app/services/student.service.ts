import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Student } from '../model/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private base: string = "http://localhost:8080/api/studenti"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get< Student[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get< Student>(`${this.base}/${id}`);
  }

  create( student:  Student) {
    return this.httpClient.post< Student>(this.base,  student);
  }

  update(id: number,  student:  Student) {
    return this.httpClient.put< Student>(`${this.base}/${id}`,  student);
  }

  delete(id: number) {
    return this.httpClient.delete< Student>(`${this.base}/${id}`);
  }
}
