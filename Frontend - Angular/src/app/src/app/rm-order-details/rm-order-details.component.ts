import { Component, OnInit } from '@angular/core';
import { RawMaterialOrderService } from '../services/raw-material-order.service';
import { RawMaterialOrderModel } from '../Models/model';

@Component({
  selector: 'app-rm-order-details',
  templateUrl: './rm-order-details.component.html',
  styleUrls: ['./rm-order-details.component.css']
})
export class RmOrderDetailsComponent implements OnInit {orderId:number;
  orderDetails:RawMaterialOrderModel;
  flags:boolean;
  dataFont:boolean;
  

  constructor(private rawServ:RawMaterialOrderService) { 
    this.orderDetails=new RawMaterialOrderModel();
  }

  ngOnInit(): void {
  }
  showOrder(){
    this.rawServ.getRawMaterialOrderDetails(this.orderId).subscribe(data=>{this.orderDetails=data,console.log(data),this.dataFont=true});
    if(this.orderDetails.orderId!=null){
      this.flags=true;
   }
  }
  onSubmit()
  {
    this.showOrder();
    
  }

}
