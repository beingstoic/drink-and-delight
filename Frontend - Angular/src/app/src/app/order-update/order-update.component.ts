import { Component, OnInit } from '@angular/core';
import { ProductOrderModel} from '../Models/model';
import { ProductService} from '../services/product.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
@Component({
  selector: 'app-order-update',
  templateUrl: './order-update.component.html',
  styleUrls: ['./order-update.component.css']
})
export class OrderUpdateComponent implements OnInit {

  
  orderDetails:ProductOrderModel;
  statuses:string[]=["BOOKED","DISPATCHED","DELIVERED","CANCELLED"];
  resCode:number;
  fail:boolean=false;
  success:boolean=false;
  submitted:boolean;
  form:FormGroup;
  
  constructor(private prodServ:ProductService) { 
    this.orderDetails=new ProductOrderModel();
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

      this.prodServ.updateProductOrderDetails(this.orderDetails).subscribe(data=>{console.log(data)},
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
