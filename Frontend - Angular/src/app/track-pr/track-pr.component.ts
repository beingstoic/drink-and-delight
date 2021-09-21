import { ProductServiceService } from './../services/product-service.service';
import { ProductStock } from './../models/product-stock';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-track-pr',
  templateUrl: './track-pr.component.html',
  styleUrls: ['./track-pr.component.css']
})
export class TrackPrComponent implements OnInit {

  orderId:number;
  model:ProductStock;
  idExist:boolean;
  submitted:boolean;
  dataFound:boolean;
  dataNotFound:boolean;

  constructor(private service:ProductServiceService) { 
    this.model=new ProductStock();
  }

  ngOnInit(): void {
  }

  findById(){
    this.submitted=true; 
    this.service.trackProduct(this.orderId).subscribe(
      (data)=>{
        this.dataFound=true;
        this.model=data;
        this.idExist=true;
        console.log(this.model);
      },
      (err)=>{
        this.dataNotFound=true;
        this.dataFound=false;
        setTimeout(()=>this.dataNotFound=false,3000);
      }
    )
  }

}
