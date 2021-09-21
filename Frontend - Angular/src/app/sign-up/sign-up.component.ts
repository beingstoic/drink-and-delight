import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router'; 
import { PasswordValidation } from '../password-validator';
import { LoginLogoutService } from '../services/login.logout.service';
import { User } from '../models/user';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  username:string='';
  password:string='';
  gender:string='';
  emailId:string='';
  confirmPassword:string='';
  success:boolean;
  model:User;

  public selection:string;

  signupValidations:FormGroup;

  constructor(private formBuilder: FormBuilder, private router:Router, private httpService: LoginLogoutService) { }
  
  ngOnInit() {

   this.model = new User();

    this.signupValidations = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(20)]],
      emailId:['', [ Validators.email, Validators.required ]],
      gender:['', Validators.required],
      password: ['', [Validators.required,Validators.minLength(6),Validators.maxLength(16)]],
      confirmPassword: ['', [Validators.required,Validators.minLength(6),Validators.maxLength(16)]]
    }, {
      validator: PasswordValidation.MatchPassword
    });
  }
 
   get f()
   {
     return this.signupValidations.controls;
   }
  get email() 
  { 
    return this.signupValidations.get('emailId');
   }

  getEmailError() {
    if (this.email.hasError('email')) {
      return 'Please enter a valid email address.';
    }
    if (this.email.hasError('required')) {
      return 'An Email is required.';
    }
  }  
  
  clickExisting=function(){
    this.router.navigateByUrl('/login');
  } 

  submitForm(){
    this.model=Object.assign(this.model,this.signupValidations.value);
    let orb=this.httpService.addUser(this.model);
    orb.subscribe((data)=>
    {
      this.success=true;
      window.alert("Don’t worry, we do not share your personal details with anyone!");
      this.router.navigateByUrl('/after-signup');
    })
  }

}
