import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { DistributorService } from '../services/distributor.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ProductOrderModel } from '../Models/model';

@Component({
  selector: 'app-track-orders',
  templateUrl: './track-orders.component.html',
  styleUrls: ['./track-orders.component.css']
})
export class TrackOrdersComponent implements OnInit {

  statuses:string[]=["BOOKED","DISPATCHED","DELIVERED","CANCELLED"];
  distributorIds:number[]=[];

  form:FormGroup;
  orders:ProductOrderModel[]=null;
  submitted:boolean=false;
  noRecordsFound:boolean;

  constructor(private distServ:DistributorService,
    private prodServ:ProductService) { }

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
  populate()
  {
    this.distServ.getDistributorIds().subscribe(data=>this.distributorIds=data);
  }
  get f()
  {
    return this.form.controls;
  }
  onSubmit()
  {  this.submitted=true;
    if(!this.form.valid)
    {
      return;
    }
    if(this.f.startDate.value!='' && this.f.endDate.value=='')
    { 
      this.f.endDate.setValue((new Date()).toISOString().substr(0, 10));
    }
    else if(this.f.startDate.value=='' && this.f.endDate.value!='')
    {
      this.f.startDate.setValue((new Date(2020,1,1)).toISOString().substr(0, 10))
    }
    console.log(this.form.value);
    let id=this.f.selectedId.value;
    let status=this.f.status.value;
    let sDate=this.f.startDate.value;
    let edate=this.f.endDate.value;

    if(sDate=='' && edate=='')
    {
        this.prodServ.trackOrdersTwo(id,status).subscribe((data)=>{this.orders=data,console.log(data);
          if(data.length==0){this.noRecordsFound=true}
          else{this.noRecordsFound=false}},
        err=>console.log(err.status));
    }
    else
    { this.prodServ.trackOrdersOne(id,status,sDate,edate)
    .subscribe((data)=>{this.orders=data,console.log(data);
      if(data.length==0){this.noRecordsFound=true}
       else{this.noRecordsFound=false}},
      err=>console.log(err.status));
    }
    this.submitted=false;
    
  }


}
