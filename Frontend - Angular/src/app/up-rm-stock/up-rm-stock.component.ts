import { RawMaterialServiceService } from './../services/raw-material-service.service';
import { RawMaterialStock } from './../models/raw-material-stock';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-up-rm-stock',
  templateUrl: './up-rm-stock.component.html',
  styleUrls: ['./up-rm-stock.component.css']
})
export class UpRmStockComponent implements OnInit {

  orderId:number;
  UpProcessDate:boolean;
  UpRmDetails:boolean;
  model:RawMaterialStock;
  submitted:boolean;
  dataFound:boolean;
  dataNotFound:boolean;
  IdExist:boolean;
  // IdExist1:boolean;
  DateUpdated:boolean;
  //resultModel:RawMaterialStock;
  resultModel:string;
  success:boolean;
  detailSubmitButton:boolean;
  errorMsg:boolean;
  constructor(private service:RawMaterialServiceService) {
      this.model=new RawMaterialStock();
   }

  ngOnInit(): void {
  }

  ProcessDate(): void {
    this.UpProcessDate=true;
    this.UpRmDetails=false;
    //this.IdExist=true;
    //this.IdExist1=false;
  }

  findById(){
    this.submitted=true; 
    this.service.findById(this.orderId).subscribe(
      (data)=>{
        this.dataFound=true;
        this.model=data;
        this.IdExist=true;
        console.log(this.model);
      },
      (err)=>{
        this.dataNotFound=true;
        this.dataFound=false;
        setTimeout(()=>this.dataNotFound=false,3000);
      }
    )
  }

  RmDetails(): void {
    this.UpRmDetails=true;
    this.UpProcessDate=false;
    //this.IdExist1=true;
    //this.IdExist=false;
  }

  setPrDate(): void {
    this.DateUpdated=true;
    this.model.orderId=this.orderId;
    if(this.model!=null){
      this.service.addProcessDate(this.model).subscribe(
        (data)=>{
          this.resultModel=data;
          this.success=true;
          setTimeout(()=>this.success=false,3000);
          this.IdExist=false;
          
        },
        (err)=>{
          this.errorMsg=true;
          setTimeout(()=>this.success=false,3000);
        }
      )
    }
    this.dataFound=false;
    this.UpProcessDate=false;
    //this.IdExist=false;
  }

  submitRmDetails(): void {

    this.detailSubmitButton=true;
    if(this.model!=null){
      this.service.updateRawMaterialDetails(this.model).subscribe(
        (data)=>{
          this.resultModel=data;
          this.success=true;
          setTimeout(()=>this.success=false,3000);
        },
        (err)=>{
          this.errorMsg=true;
          setTimeout(()=>this.success=false,3000);
        }
      )
    }

    this.UpRmDetails=false;
    //this.IdExist1=false;
  }
}
