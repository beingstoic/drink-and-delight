import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, from } from 'rxjs';
import {SupplierModel} from '../Models/model';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {
  private baseUrl:string;
  private apiUrl="http://localhost:7777/rmos/supplier";
  constructor(private http: HttpClient) 
  { 
    this.apiUrl="http://localhost:7777/rmos/supplier";
  }
  getSupplierList():Observable<SupplierModel[]> {
  
    return this.http.get<SupplierModel[]>(this.apiUrl);
  
  }
  getSupplierIds():Observable<string[]>
  {
     return this.http.get<string[]>(this.apiUrl);
  }
  getSupplierDetails(id:number):Observable<SupplierModel>
  {
   return this.http.get<SupplierModel>(`${this.apiUrl}/${id}`);
  }
}


