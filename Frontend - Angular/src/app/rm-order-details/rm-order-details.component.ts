import { Component, OnInit } from '@angular/core';
import { RawMaterialOrderService } from '../services/raw-material-order.service';
import { RawMaterialOrderModel } from '../Models/model';
import { FormControl, FormGroup } from '@angular/forms';
import {Validators} from '@angular/forms'

@Component({
  selector: 'app-rm-order-details',
  templateUrl: './rm-order-details.component.html',
  styleUrls: ['./rm-order-details.component.css']
})
export class RmOrderDetailsComponent implements OnInit {orderId:number;
  orderDetails:RawMaterialOrderModel;
  submitted:boolean=false;
  form:FormGroup;
  fail:boolean=false;
  success:boolean=false;
  

  constructor(private rawServ:RawMaterialOrderService) { 
    this.orderDetails=new RawMaterialOrderModel();
  }
  ngOnInit(): void {
    this.createForm();
   }
   createForm()
   {
     this.form=new FormGroup({
       orderId:new FormControl('',[Validators.required])
     });
   }
   get f()
   {
     return this.form.controls;
   }
   onSubmit()
   { this.submitted=true;
     if(!this.form.valid)
     { this.success=false;
       return;
     }
     this.rawServ.getRawMaterialOrderDetails(this.f.orderId.value).subscribe(data=>{this.orderDetails=Object.assign(data),console.log(data),this.success=true},
     err=>{if(err){
       this.fail=true;
       this.success=false;
       setTimeout(()=>{this.fail=false},4000)}
     });
 
     this.createForm();
     this.submitted=false;
   }

}
