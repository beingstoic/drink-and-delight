import { Component, OnInit } from '@angular/core';
import {RawMaterialOrderService} from '../services/raw-material-order.service';

import {RawMaterialOrderModel} from '../Models/model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rm-order-update',
  templateUrl: './rm-order-update.component.html',
  styleUrls: ['./rm-order-update.component.css']
})
export class RmOrderUpdateComponent implements OnInit {

  orderId:number;
  status:string;
  orderDetails:RawMaterialOrderModel;
  statuses:string[]=["BOOKED","DISPATCHED","DELIVERED","CANCELLED"]
  updateStatus:string;
  constructor(private rawServ:RawMaterialOrderService) { 
    this.orderDetails=new RawMaterialOrderModel();
  }

  ngOnInit(): void {
  }

  onSubmit()
  { this.orderDetails.orderId =this.orderId;
    this.orderDetails.deliveryStatus=this.status;
    this.rawServ. updateRawMaterialOrderDetails (this.orderDetails).subscribe(data=>{this.updateStatus=data,console.log(data)});
  }
}
