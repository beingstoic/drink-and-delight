import { Component, OnInit } from '@angular/core';
import {RawMaterialOrderService} from '../services/raw-material-order.service';

import {RawMaterialOrderModel} from '../Models/model';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rm-order-update',
  templateUrl: './rm-order-update.component.html',
  styleUrls: ['./rm-order-update.component.css']
})
export class RmOrderUpdateComponent implements OnInit {

  orderDetails:RawMaterialOrderModel;
  statuses:string[]=["BOOKED","DISPATCHED","DELIVERED","CANCELLED"];
  resCode:number;
  fail:boolean=false;
  success:boolean=false;
  submitted:boolean;
  form:FormGroup;
  constructor(private rawServ:RawMaterialOrderService) { 
    this.orderDetails=new RawMaterialOrderModel();
  }

  ngOnInit(): void {
    this.form=new FormGroup({
     orderId:new FormControl('',[Validators.required]),
     status:new FormControl('',[Validators.required])
   })
   }
   get f()
   {
     return this.form.controls;
   }
 
   onSubmit()
   {   this.submitted=true;
     if(!this.form.valid)
     {
       return;
     }
       this.orderDetails.orderId=this.f.orderId.value;
       this.orderDetails.deliveryStatus=this.f.status.value;
 
       this.rawServ.updateRawMaterialOrderDetails(this.orderDetails).subscribe(data=>{console.log(data)},
         err=>{this.resCode=err.status,console.log(err.status);
         if(err.status==200)
         { this.success=true
           setTimeout(()=>this.success=false,4000);
         }
         else if(err.status==400)
         {
           this.fail=true
           setTimeout(()=>this.fail=false,4000); 
         }
       })
        
       this.submitted=false;
   }
 }