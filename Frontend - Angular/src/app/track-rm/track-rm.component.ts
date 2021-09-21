import { RawMaterialServiceService } from './../services/raw-material-service.service';
import { RawMaterialStock } from './../models/raw-material-stock';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-track-rm',
  templateUrl: './track-rm.component.html',
  styleUrls: ['./track-rm.component.css']
})
export class TrackRmComponent implements OnInit {

  orderId:number;
  model:RawMaterialStock;
  idExist:boolean;
  submitted:boolean;
  dataFound:boolean;
  dataNotFound:boolean;

  constructor(private service:RawMaterialServiceService) { 
    this.model=new RawMaterialStock();
  }

  ngOnInit(): void {
  }

  findById(){
    this.submitted=true; 
    this.service.trackRawMaterial(this.orderId).subscribe(
      (data)=>{
        this.dataFound=true;
        this.model=data;
        this.idExist=true;
        console.log(this.model);
      },
      (err)=>{
        this.dataNotFound=true;
        this.dataFound=false;
        setTimeout(()=>this.dataNotFound=false,3000);
      }
    )
  }


}
