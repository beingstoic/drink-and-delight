import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from  '@angular/forms';
import {SupplierService} from '../services/supplier.service';
import {RawMaterialOrderService} from '../services/raw-material-order.service';
import {WarehouseService} from '../services/warehouse.service';
import {Validators} from '@angular/forms';

import {SupplierModel, WarehouseModel,RawMaterialOrderModel, RawMaterialModel} from '../Models/model';
import { Router } from '@angular/router';
@Component({
  selector: 'app-raw-material-order',
  templateUrl: './raw-material-order.component.html',
  styleUrls: ['./raw-material-order.component.css']
})
export class RawMaterialOrderComponent implements OnInit {
  suppliers:SupplierModel[];
  warehouses:WarehouseModel[];
  suppliersid:number[];
  rawMaterials:RawMaterialModel [];
  rawMaterialOrderForm: FormGroup;
  order:RawMaterialOrderModel;

  isValidFormSubmitted = false;
  resCode:number;
  success:boolean=false;
  fail:boolean=false;
  submitted:boolean=false;

  
  ngOnInit(): void {
    this.populate();
    this.createOrderForm();
  }
  constructor(private formBuilder: FormBuilder,
              private supp:SupplierService, 
              private whouse:WarehouseService,
              private rawServ:RawMaterialOrderService,
               private router:Router) {
    this.order=new RawMaterialOrderModel();
  }
  
  createOrderForm(){
    this.rawMaterialOrderForm = this.formBuilder.group({
      orderId:['',[Validators.required, Validators.minLength(3)]],
      rawMaterialName: ['',Validators.required],  
      supplierId: ['',Validators.required],
      quantityValue: ['',Validators.required,],
      quantityUnit: ['',[Validators.required,Validators.maxLength(3)]],
      pricePerUnit:['',Validators.required],
      warehouseId:['',Validators.required],
      totalPrice:['',Validators.required],
      dateOfOrder:[(new Date()).toISOString().substr(0, 10),Validators.required],
      dateOfDelivery:['',Validators.required]
      
    });
    this.setDateAndId();
  }

    setDateAndId()
    {
     this.f.dateOfOrder.setValue((new Date()).toISOString().substr(0, 10));
     this.rawServ.getOrderId().subscribe(data =>{this.f.orderId.setValue(data);console.log(data)});
    }

    get f(){
      return this.rawMaterialOrderForm.controls;
    }
    ngOnViewInit()
    {
      
    }  
    populate()
    {
      this.supp.getSupplierList().subscribe(response =>{this.suppliers=response;console.log(response)});
      this.whouse.getWarehouseList().subscribe(response =>{this.warehouses=response;console.log(response)});
      this.rawServ.getRawMaterialList().subscribe((data) =>{this.rawMaterials=data;});
      
     }
    updateUnitPrice(selection:string)
    {
      this.rawMaterials.forEach(p=>{if(p.materialName.toString().localeCompare(selection)){
      this.f.pricePerUnit.setValue(p.pricePerUnit);
    }});
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
    this.isValidFormSubmitted=this.rawMaterialOrderForm.valid;
      console.log('Your form data : ', this.rawMaterialOrderForm.value );
     
      if(!this.rawMaterialOrderForm.valid)
      {
        return;
      }
      
      console.log('Your form data :', this.rawMaterialOrderForm.value)
      this.order.orderId=this.f.orderId.value;
      this.order.deliveryStatus="BOOKED";
      this.order.supplierId=(this.f.supplierId.value);
      this.order.pricePerUnit=this.f.pricePerUnit.value;
      this.order.rawMaterialName=this.f.rawMaterialName.value;
      this.order.quantityValue=this.f.quantityValue.value;
      this.order.quantityUnit=this.f.quantityUnit.value;
      this.order.pricePerUnit=this.f.pricePerUnit.value;
      this.order.warehouseId=(this.f.warehouseId.value);
      this.order.dateOfOrder=this.f.dateOfOrder.value;
      this.order.delDate=this.f.dateOfDelivery.value;
      this.order.totalPrice= this.f.totalPrice.value;
      console.log(this.order);

      this.rawServ.addOrder(this.order).subscribe(data=>{console.log(data); this.success=true
        setTimeout(()=>this.success=false,4000);},err=>{this.resCode=parseInt(err.status);console.log(err.status);
        this.fail=true;
        setTimeout(()=>this.fail=false,4000);
    });
      
      this.createOrderForm();
      this.submitted=false;
      
    }
}

  


  