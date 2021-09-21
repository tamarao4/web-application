import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ObjavljeniNaucniRad } from '../model/objavljeni-naucni-rad';

@Injectable({
  providedIn: 'root'
})
export class ObjavljeniNaucniRadService {

 
  private base: string = "http://localhost:8080/api/objavljeniNaucniRad"
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get< ObjavljeniNaucniRad[]>(this.base);
  }

  getOne(id: number) {
    return this.httpClient.get< ObjavljeniNaucniRad>(`${this.base}/${id}`);
  }

  create( objavljeniNaucniRad:  ObjavljeniNaucniRad) {
    return this.httpClient.post< ObjavljeniNaucniRad>(this.base,  objavljeniNaucniRad);
  }

  update(id: number,  objavljeniNaucniRad:  ObjavljeniNaucniRad) {
    return this.httpClient.put< ObjavljeniNaucniRad>(`${this.base}/${id}`,  objavljeniNaucniRad);
  }

  delete(id: number) {
    return this.httpClient.delete< ObjavljeniNaucniRad>(`${this.base}/${id}`);
  }
}
