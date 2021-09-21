import { Component, OnInit } from '@angular/core';
import { RawMaterialOrderService } from '../services/raw-material-order.service';
import { SupplierService } from '../services/supplier.service';
import { SupplierModel, RawMaterialOrderModel, trackModel } from '../Models/model';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-rm-track-order',
  templateUrl: './rm-track-order.component.html',
  styleUrls: ['./rm-track-order.component.css']
})
export class RmTrackOrderComponent implements OnInit {

  selectedId:number;
  track:trackModel;
  supplierDetails:SupplierModel;
  status:string;
  startDate:Date
  endDate:Date
  supplierIds:SupplierModel[];
  orderDetails:RawMaterialOrderModel[];
  statuses:string[]=["BOOKED","DISPATCHED","DELIVERED","CANCELLED"];
  constructor(private supServ:SupplierService,private actRt: ActivatedRoute,
    private router:Router,private rawServ: RawMaterialOrderService) { 
      this.supplierDetails = new SupplierModel;
      this.track = new trackModel;
    }

  ngOnInit(): void {
    this.populate();
  }
  populate()
  {
    this.supServ.getSupplierList().subscribe(response =>{this.supplierIds=Object.assign(response);console.log(response)});
  }
  onSubmit()
  {
    this.track.supplierId=this.selectedId;
    this.track.status=this.status;
    this.track.startDate=this.startDate;
    this.track.endDate=this.endDate;
    this.rawServ.trackRawMaterialOrder(this.track).subscribe(response=>{this.orderDetails = response; console.log(response)});
  }


}