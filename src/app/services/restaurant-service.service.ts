import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Restaurant } from '../entites/restaurant';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Type } from '../entites/type';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  constructor(private http: HttpClient, private fb: FormBuilder) { }

  /*public getForm() {
    return this.fb.group({
      id: '',
      nom: ['' , Validators.required],
      description: ['' , Validators.required],
      type: ['' , Validators.required]
    })
  }*/

  public search (nom: string): Observable<Restaurant[]> {
    return this.http.get<Restaurant[]>("http://localhost:8081/api/restaurant?nom=" + nom)
  }

  public read (id: number) {
    return this.http.get<Restaurant>("http://localhost:8081/api/restaurant/" + id)
  }

  public searchType (nomType: string, nomResto: string): Observable<Restaurant[]> {
    return this.http.get<Restaurant[]>("http://localhost:8081/api/restaurant?type=" + nomType + "&nom=" + nomResto)
  }

}