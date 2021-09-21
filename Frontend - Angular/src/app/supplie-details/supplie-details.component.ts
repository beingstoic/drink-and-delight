import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { SupplierModel } from '../Models/model';
import { SupplierService } from '../services/supplier.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-supplie-details',
  templateUrl: './supplie-details.component.html',
  styleUrls: ['./supplie-details.component.css']
})
export class SupplieDetailsComponent implements OnInit {
  supplierIds:SupplierModel[];
  SupplierrDetails:SupplierModel;
  submitted:Boolean=false;
  success:boolean=false;
  fail:boolean=false;
  form:FormGroup;
  constructor(private supServ:SupplierService,private actRt: ActivatedRoute,
    private router:Router) { 
        this.SupplierrDetails = new SupplierModel;
    }

    ngOnInit(): void {
      this.createForm();
      
    }
    get f()
    {
    return this.form.controls;
    }
    createForm()
    {
        this.form=new FormGroup({
        selectedId:new FormControl('',[Validators.required])
        });
        this.populate();
    }
  populate(){
    this.supServ.getSupplierList().subscribe(data=>this.supplierIds=data);
  }
  onSubmit()
  { this.submitted=true;
    if(!this.form.valid)
    {
      this.success=false;
      return;
    }
    let supId=Number(this.f.selectedId.value);
    console.log(this.f.selectedId.value)
    this.supServ.getSupplierDetails(supId).subscribe(data=>{this.SupplierrDetails=Object.assign(data),console.log(this.SupplierrDetails),this.success=true});
  }


}
