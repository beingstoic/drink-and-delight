import { Component, OnInit } from '@angular/core';
import { LoginLogoutService } from '../services/login.logout.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLoggedIn:boolean;
  subscription: Subscription;
  constructor(private serv:LoginLogoutService,private router:Router) 
  {
       this.subscription=this.serv.isloggedIn().subscribe(change=>this.isLoggedIn=change);
   }

  ngOnInit(): void {
    
    
  }
   logout()
   {  this.serv.logoutUser();
     
   }
}
