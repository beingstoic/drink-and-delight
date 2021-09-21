import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import {DistributorService} from '../services/distributor.service';
import { DistributorModel } from '../Models/model';
import { FormControl, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-distributor-details',
  templateUrl: './distributor-details.component.html',
  styleUrls: ['./distributor-details.component.css']
})
export class DistributorDetailsComponent implements OnInit {

  distributorIds:number[]=[];
  distributorDetails:DistributorModel;
  submitted:boolean=false;
  success:boolean=false;
  fail:boolean=false;
  form:FormGroup;

  constructor(private distServ:DistributorService,
    private actRt: ActivatedRoute,
    private router:Router)
     {
      this.distributorDetails=new DistributorModel();
     }

  ngOnInit(): void {
    this.createForm();
    
  }
  createForm()
  {
      this.form=new FormGroup({
      selectedId:new FormControl('',[Validators.required])
      });
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
  { this.submitted=true;
    if(!this.form.valid)
    {
      this.success=false;
      return;
    }
    let distId=Number(this.f.selectedId.value);
    console.log(this.f.selectedId.value);
    //console.log(distId)
    this.distServ.getDistributorDetails(distId).subscribe(data=>{this.distributorDetails=Object.assign(data),console.log(data),this.success=true});
    this.createForm();
    this.submitted=false;
  }

}
