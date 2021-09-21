import { ProductServiceService } from './../services/product-service.service';
import { ProductStock } from './../models/product-stock';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-up-pr-stock',
  templateUrl: './up-pr-stock.component.html',
  styleUrls: ['./up-pr-stock.component.css']
})
export class UpPrStockComponent implements OnInit {

  orderId:number;
  UpExitDate:boolean;
  UpProductDetails:boolean;
  model:ProductStock;
  submitted:boolean;
  dataFound:boolean;
  dataNotFound:boolean;
  IdExist:boolean;
  IdExist1:boolean;
  DateUpdated:boolean;
  resultModel:string;
  success:boolean;
  detailSubmitButton:boolean;
  errorMsg:boolean;

  constructor(private service:ProductServiceService) {
     this.model=new ProductStock();
   }

  ngOnInit(): void {
  }

  productDetails() {
    this.UpProductDetails=true;
    this.UpExitDate=false;
    //this.IdExist1=true;
    //this.IdExist=false;

  }

  findById(){
    this.submitted=true; 
    this.service.findById(this.orderId).subscribe(
      (data)=>{
        this.dataFound=true;
        this.model=data;
        this.IdExist1=true;
        console.log(this.model);
      },
      (err)=>{
        this.dataNotFound=true;
        this.dataFound=false;
        setTimeout(()=>this.dataNotFound=false,3000);
      }
    )
  }

  exitDate(){
    this.UpExitDate=true;
    this.UpProductDetails=false;
    //this.IdExist=true;
    //this.IdExist1=false;
  }

  submitProductDetails() {
    
    this.detailSubmitButton=true;
    if(this.model!=null){
       this.model.orderId=this.orderId;
      this.service.updateProductDetails(this.model).subscribe(
        (data)=>{
          this.resultModel=data;
          this.success=true;
          setTimeout(()=>this.success=false,3000);
          this.IdExist1=false;
        },
        (err)=>{
          this.errorMsg=true;
          setTimeout(()=>this.success=false,3000);
        }
      )
    }
    
    this.UpProductDetails=false;
    this.dataFound=false;

    //this.IdExist1=false;
  }

  setExitDate() {
    this.DateUpdated=true;
    //this.model.orderId=this.orderId;
    if(this.model!=null){
      
      this.service.addExitDate(this.model).subscribe(
        (data)=>{
          this.resultModel=data;
          console.log(this.resultModel);
          console.log(data);
          this.success=true;
          setTimeout(()=>this.success=false,3000);
          //this.IdExist=false;
          
        },
        (err)=>{
          this.errorMsg=true;
          setTimeout(()=>this.success=false,3000);
        }
      )
    }
    this.UpExitDate=false;
    //this.IdExist=false;
  }


}
