import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, from } from 'rxjs';
import {WarehouseModel} from '../Models/model'
@Injectable({
  providedIn: 'root'
})
export class WarehouseService {
private apiUrl="http://localhost:7777/pos/warehouse";
  constructor(private http: HttpClient) 
  { }

  getWarehouseList() :Observable<WarehouseModel[]>{
    return this.http.get<WarehouseModel[]>(this.apiUrl);
}
}
