import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { ProductOrderModel } from '../Models/model';
import { FormControl, FormGroup } from '@angular/forms';
import {Validators} from '@angular/forms'
@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  odrDetail:ProductOrderModel;
  submitted:boolean=false;
  form:FormGroup;
  fail:boolean=false;
  success:boolean=false;
  constructor(private prodServ:ProductService) { 
    this.odrDetail=new ProductOrderModel();
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
    this.prodServ.getproductOrderDetails(this.f.orderId.value).subscribe(data=>{this.odrDetail=Object.assign(data),console.log(data),this.success=true},
    err=>{if(err){
      this.fail=true;
      this.success=false;
      setTimeout(()=>{this.fail=false},4000)}
    });

    this.createForm();
    this.submitted=false;
  }

}
