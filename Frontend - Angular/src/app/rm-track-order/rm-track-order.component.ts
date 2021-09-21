import { Component, OnInit } from '@angular/core';
import { RawMaterialOrderService } from '../services/raw-material-order.service';
import { SupplierService } from '../services/supplier.service';
import { SupplierModel, RawMaterialOrderModel, trackModel } from '../Models/model';
import {ActivatedRoute, Router} from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-rm-track-order',
  templateUrl: './rm-track-order.component.html',
  styleUrls: ['./rm-track-order.component.css']
})
export class RmTrackOrderComponent implements OnInit {
  form:FormGroup;
  success:boolean=false;
  submitted:boolean=false;
  noRecordsFound:boolean;
  track:trackModel;
  supplierDetails:SupplierModel;
  supplierIds:SupplierModel[];
  orderDetails:RawMaterialOrderModel[];
  statuses:string[]=["BOOKED","DISPATCHED","DELIVERED","CANCELLED"];

  constructor(private supServ:SupplierService,private actRt: ActivatedRoute,
    private router:Router,private rawServ: RawMaterialOrderService) { 
      this.supplierDetails = new SupplierModel;
      this.track = new trackModel;
    }

    ngOnInit(): void {
      this.createForm(); 
    }
    createForm()
    {
      this.form=new FormGroup({
        selectedId:new FormControl('',[Validators.required]),
        status:new FormControl('',[Validators.required]),
        startDate:new FormControl('',[]),
        endDate:new FormControl('',[])
      })
      this.populate();
    }
    get f()
    {
      return this.form.controls;
    }
  populate()
  {
    this.supServ.getSupplierList().subscribe(response =>{this.supplierIds=Object.assign(response);console.log(response)});
  }
  onSubmit()
  {
    this.submitted=true;
    if(!this.form.valid)
    {
      return;
    }
    this.track.supplierId=this.f.selectedId.value;
    this.track.status=this.f.status.value;
    this.track.startDate=this.f.startDate.value;
    this.track.endDate=this.f.endDate.value;
    this.rawServ.trackRawMaterialOrder(this.track).subscribe(response=>{this.orderDetails = response; console.log(response);;
      if(this.orderDetails.length==0){this.noRecordsFound=true}
      else{this.noRecordsFound=false;
           this.success=true;}},
    err=>console.log(err.status));
  }


}