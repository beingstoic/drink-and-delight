import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from  '@angular/forms';
import {Validators} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {DistributorService} from '../services/distributor.service';
import {ProductService} from '../services/product.service';
import {WarehouseService} from '../services/warehouse.service';

import {DistributorModel, WarehouseModel,ProductModel,ProductOrderModel} from '../Models/model';


@Component({
  selector: 'app-product-order',
  templateUrl: './product-order.component.html',
  styleUrls: ['./product-order.component.css']
})
export class ProductOrderComponent implements OnInit {

  distributors:DistributorModel[];
  warehouses:WarehouseModel[];
  products:ProductModel[];
  productOrderForm: FormGroup;
  order:ProductOrderModel;

  isValidFormSubmitted = false;
  resCode:number;
  success:boolean=false;
  fail:boolean=false;
  submitted:boolean=false;
 

  constructor(private formBuilder: FormBuilder,
    private dist:DistributorService, 
    private whouse:WarehouseService,
    private prodServ:ProductService,
    private router: Router)
     {
        this.order=new ProductOrderModel();    
    }

    ngOnInit(): void {
      this.populate();
      this.createOrderForm();
      
    }

  createOrderForm(){
    this.productOrderForm = this.formBuilder.group({
      orderId:['',[Validators.required,Validators.minLength(5),Validators.maxLength(5)]],
      productName: ['',Validators.required],  
      distributorId: ['',Validators.required],
      quantityValue: ['',Validators.required],
      pricePerUnit:['',Validators.required],
      warehouseId:['',Validators.required],
      totalPrice:['',Validators.required],
      dateOfOrder:['',Validators.required],
      dateOfDelivery:['',Validators.required]
      
    });
    this.setDateAndId();
  }

  get f() 
   {
      return this.productOrderForm.controls; 
   }

 populate()
 {
   
 
    this.dist.getDistributorList().subscribe(response =>this.distributors=response);
   this.whouse.getWarehouseList().subscribe(response =>{this.warehouses=response;console.log(response)});
   this.prodServ.getProductList().subscribe((data) =>{this.products=data;});
    // this.dist.getDistributorList().subscribe(response =>response.map(e=>console.log(e)));
  //this.prod.getProductList().subscribe(response =>{this.products= new ProductModel(response.productId,response.productName,response.pricePerUnit,response.productDuration,response.productDescription);});
  // this.f.orderId.setValue(parseInt(this.prod.getOrderId())+1);
 // this.sample.map(e=>console.log(e));
 
 }
 setDateAndId()
 {
    this.f.dateOfOrder.setValue((new Date()).toISOString().substr(0, 10));
    this.prodServ.getOrderId().subscribe(data =>{this.f.orderId.setValue(data);console.log(data)});
 }
  updateUnitPrice(selection:string)
  {
    this.products.forEach(p=>{if(p.productName.toString().localeCompare(selection)){
      this.f.pricePerUnit.setValue(p.pricePerUnit);
    }});
    
    //console.log(this.f.pricePerUnit.value);
    //console.log("hi");

  }
   checkDate(dod:Date)
   {
       if(dod<this.f.dateOfOrder.value)
       {
         console.log("date error");
         this.f.dateOfDelivery.errors.setValue(true)
       }
       else
       console.log("date ok");
   }
   updateBillAmount()
   {
       this.f.totalPrice.setValue(this.f.quantityValue.value*this.f.pricePerUnit.value);
   }
  onSubmit() {
    this.submitted=true;
    if(!this.productOrderForm.valid)
    {
         return;
    }
    console.log('Your form data : ', this.productOrderForm.value );
      
      this.order.orderId=this.f.orderId.value;
      this.order.deliveryStatus="BOOKED";
      this.order.distributorId=parseInt(this.f.distributorId.value);
      this.order.pricePerUnit=this.f.pricePerUnit.value;
      this.order.productName=this.f.productName.value;
      this.order.quantity=this.f.quantityValue.value;
      this.order.totalPrice=this.f.totalPrice.value;
      this.order.warehouseId=parseInt(this.f.warehouseId.value);
      this.order.dateOfOrder=this.f.dateOfOrder.value;
      this.order.dateOfDelivery=this.f.dateOfDelivery.value;
      console.log(this.order);

      this.prodServ.addOrder(this.order).subscribe(data=>{console.log(data); this.success=true
        setTimeout(()=>this.success=false,4000);},err=>{this.resCode=parseInt(err.status);console.log(err.status);
        this.fail=true;
        setTimeout(()=>this.fail=false,4000);
    });
      this.createOrderForm();
      this.submitted=false;
    }

}
