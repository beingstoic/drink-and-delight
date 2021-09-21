import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, from } from 'rxjs';

import {DistributorModel} from '../Models/model'

@Injectable({
  providedIn: 'root'
})



export class DistributorService {
  private baseUrl:string;
// apiUrl="http://localhost:7010/distributor";
  constructor(private http: HttpClient) 
  { 
    
    this.baseUrl=`http://localhost:7777/pos/distributor`;
  }

  getDistributorList():Observable<DistributorModel[]> {
  
    return this.http.get<DistributorModel[]>(this.baseUrl);
  }

  getDistributorIds():Observable<number[]>
  {
     return this.http.get<number[]>(this.baseUrl+"/ids");
  }
  getDistributorDetails(id:number):Observable<DistributorModel>
  {
   return this.http.get<DistributorModel>(`${this.baseUrl}/${id}`);
   // return this.http.get<DistributorModel>(this.apiUrl+"/"+1001);
  }
}

