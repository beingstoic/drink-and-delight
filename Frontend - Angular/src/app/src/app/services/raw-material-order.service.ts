import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {RawMaterialOrderModel, RawMaterialModel, trackModel} from '../Models/model'

@Injectable({
  providedIn: 'root'
})
export class RawMaterialOrderService {
  private nameUrl="http://localhost:7777/rmos/materials";
  private apiUrl="http://localhost:7777/rmos/rawMaterialOrder";
  constructor(private http: HttpClient) 
  { 
    
  }

  getRawMaterialList():Observable<RawMaterialModel[]> {

      return (this.http.get<RawMaterialModel[]>(this.nameUrl));
      
  }


addOrder(order:RawMaterialOrderModel):Observable<RawMaterialOrderModel>
{
    return this.http.post<RawMaterialOrderModel>(this.apiUrl,order)
}
getRawMaterialOrderDetails(id:number):Observable<RawMaterialOrderModel>
{
    return this.http.get<RawMaterialOrderModel>(this.apiUrl+"/"+id);
}
updateRawMaterialOrderDetails(order:RawMaterialOrderModel):Observable<string>
{
     return this.http.put<string>(this.apiUrl+"/",order);
}
trackRawMaterialOrder(track:trackModel):Observable<RawMaterialOrderModel[]>{
  return this.http.post<RawMaterialOrderModel[]>(this.apiUrl+"/display",track);
}
}



