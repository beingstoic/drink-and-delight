import { RawMaterialStock } from './../models/raw-material-stock';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RawMaterialServiceService {

  baseUrl:String;

  constructor(private http:HttpClient) {
      this.baseUrl="http://localhost:7777/sms";
   }

  //  addProcessDate(rawMaterialStock:RawMaterialStock):Observable<RawMaterialStock> {
  //     return this.http.post<RawMaterialStock>(`${this.baseUrl}/updateRawMaterial`,rawMaterialStock);
  //  }

   addProcessDate(rawMaterialStock:RawMaterialStock):Observable<string> {
    return this.http.post<string>(`${this.baseUrl}/updateRawMaterial`,rawMaterialStock);
   }


   findById(orderId:number):Observable<RawMaterialStock>{
    return this.http.get<RawMaterialStock>(`${this.baseUrl}/updateRawMaterial/${orderId}`);
  }

   updateRawMaterialDetails(rawMaterialStock:RawMaterialStock):Observable<string> {
     return this.http.put<string>(`${this.baseUrl}/updateRawMaterial`,rawMaterialStock);
   }

   trackRawMaterial(orderId:number):Observable<RawMaterialStock>{
    return this.http.get<RawMaterialStock>(`${this.baseUrl}/trackrawmaterial/${orderId}`); 
  }

}
