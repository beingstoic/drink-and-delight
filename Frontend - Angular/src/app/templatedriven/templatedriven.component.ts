import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {Product} from '..//model/product';

@Component({
  selector: 'app-templatedriven',
  templateUrl: './templatedriven.component.html',
  styleUrls: ['./templatedriven.component.css']
})
export class TemplatedrivenComponent implements OnInit {

  productCategoryArray=["Grocery","Mobile","Electronics","Cloths"];
  checkBoxArray: Array<any> = [
    { name: 'Big Bazar', value: 'big bazar',selected:false },
    { name: 'DMart', value: 'dmart',selected:false },
    { name: 'Reliance', value: 'reliance',selected:false },
    { name: 'Mega Store', value: 'mega store',selected:false},
    
  ];
  public prd:Product;
  isValidFormSubmitted = false;
  constructor() { }

  ngOnInit(): void {
    
    this.prd=new Product();
  }

  show(form:NgForm){
    this.isValidFormSubmitted = true;
    if(form.invalid){
      return;
    }

    this.prd.productId=form.controls['id'].value;
    this.prd.productName=form.controls['name'].value;
    this.prd.productCost=form.controls['cost'].value;
    this.prd.productOnline=form.controls['online'].value;
    this.prd.productCategory=form.controls['category'].value;
    //this.prd.productStore=this.checkBoxArray.filter( (country) => country.checked );
    
   
    console.log("Product Id: "+this.prd.productId);
    console.log("Product Name: "+this.prd.productName);
    console.log("Product Cost: "+this.prd.productCost);
    console.log("Product Online: "+this.prd.productOnline);
    console.log("Product Category: "+this.prd.productCategory);
    console.log("Product Store Available: "+ this.prd.productStore.Store);
    
    form.reset();
  
  }
  onCheckboxChange(e,data) {
    this.prd.productStore.Store.push(data.name);
    /*const checkArray: FormArray = this.form.get('checkArray') as FormArray;
    

    if (e.target.checked) {
      checkArray.push(new FormControl(e.target.value));
    } else {
      let i: number = 0;
      checkArray.controls.forEach((item: FormControl) => {
        if (item.value == e.target.value) {
          checkArray.removeAt(i);
          return;
        }
        i++;
      });
    }*/
  }

}
