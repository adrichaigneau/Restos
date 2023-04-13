import { Injectable } from '@angular/core';
import { Type } from '../entites/type';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TypeService {

  constructor(private http: HttpClient) { }

  public read (id: number) {
    return this.http.get<Type>("http://localhost:8081/api/type/" + id)
  }
}
