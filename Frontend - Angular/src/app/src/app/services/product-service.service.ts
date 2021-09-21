import { ProductStock } from './../models/product-stock';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  baseUrl:string;
  exDate:string;

  constructor(private http:HttpClient) { 
    this.baseUrl="http://localhost:7777/sms";
    this.exDate=`updateProduct/updateExitDate`;
  }

  addExitDate(productStock:ProductStock):Observable<string> {
    return this.http.put<string>(`${this.baseUrl}/${this.exDate}`,productStock);
  }

  findById(orderId:number):Observable<ProductStock>{
    return this.http.get<ProductStock>(`${this.baseUrl}/updateProduct/${orderId}`);
  }

  updateProductDetails(productStock:ProductStock):Observable<string> {
    return this.http.put<string>(`${this.baseUrl}/updateProduct`,productStock);
  }

  trackProduct(orderId:number):Observable<ProductStock>{
    return this.http.get<ProductStock>(`${this.baseUrl}/trackproduct/${orderId}`); 
  }

}
