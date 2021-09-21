import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {ProductModel,ProductOrderModel} from '../Models/model';

@Injectable({
    providedIn: 'root'
})
    
export class ProductService {
    private apiUrl="http://localhost:7777/pos/product";
 temp;

    constructor(private http: HttpClient) 
    { }

    getProductList():Observable<ProductModel[]> {

        return (this.http.get<ProductModel[]>("http://localhost:7777/pos/products"));
        
    }
    getOrderId():Observable<number>
    {
        return this.http.get<number>(this.apiUrl+"/nId");
    }

    addOrder(order:ProductOrderModel):Observable<ProductOrderModel>
    {   
        this.temp= this.http.post<ProductOrderModel>(this.apiUrl,order);
        console.log(this.temp)
        return this.temp;
    }
    getproductOrderDetails(id:number):Observable<ProductOrderModel>
    {
        return this.http.get<ProductOrderModel>(this.apiUrl+"/"+id);
    }
    updateProductOrderDetails(order:ProductOrderModel):Observable<string>
    {
         return this.http.put<string>(this.apiUrl,order);
    }

    trackOrdersOne(id,status,sDate,eDate):Observable<ProductOrderModel[]>
    {
        return this.http.get<ProductOrderModel[]>(this.apiUrl+"/"+id+"/"+status+"/"+sDate+"/"+eDate);
    }
    trackOrdersTwo(id,status):Observable<ProductOrderModel[]>
    {
        return this.http.get<ProductOrderModel[]>(this.apiUrl+"/"+id+"/"+status);
    }
}