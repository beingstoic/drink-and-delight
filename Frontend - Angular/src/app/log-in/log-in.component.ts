import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router'; 
import { LoginLogoutService } from '../services/login.logout.service';
import { User } from '../models/user';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css'],
})
export class LogInComponent implements OnInit {

  username:string='';
  password:string='';
  open:boolean;
  submitted:boolean=false;
  userValidations:FormGroup;
  isLoginError:boolean;
  isLoggedIn:boolean;
  subscription: Subscription;
  constructor(private formBuilder: FormBuilder, private router:Router, private logServ:LoginLogoutService) { 
    this.subscription=this.logServ.isloggedIn().subscribe(change=>this.isLoggedIn=change);
  }
 
  ngOnInit() {
    
    if(this.isLoggedIn==true)
    {
      this.router.navigate(['/home']);
    }
    else
      this.createForm();
   
  }
  createForm()
  { 
    this.userValidations = this.formBuilder.group({
    username: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(20)]],
    password: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(16)]],
  });

  }
  get f()
  {
    return this.userValidations.controls;
  }
  clickLogin(){
    this.submitted=true;
    if(!this.userValidations.valid)
    {
      return;
    }

    this.logServ.loginUser(Object.assign(this.userValidations.value)).subscribe(
      (data)=>{
        if(data!=null){
          this.open=true;
         window.alert("Hola, Welcome Back!");
          sessionStorage.setItem('token',"Bearer "+data.token);
          console.log(sessionStorage.getItem('token'));
          //console.log(data)
          sessionStorage.setItem('username',this.userValidations.controls.username.value)
          this.router.navigateByUrl("/home");
        }
        else{
          this.isLoginError=true;
          setTimeout(()=>this.isLoginError=false,4000);
        }
         
          //this.displaySuccessMsg();
      },
      (error)=>{
        console.log("error");
        window.alert("Hey, It seems like you entered a wrong Username or Password!");
       // this.isLoginError=true;
        this.router.navigate(['/login']);
      }
    );
    this.userValidations.reset();
    this.submitted=false;  
 }

  forgotPassword=function(){
    this.router.navigateByUrl('/forgot-password');
  };

  clickSignup=function(){
    this.router.navigateByUrl('/sign-up');
  };

}
