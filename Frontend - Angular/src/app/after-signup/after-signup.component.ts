import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-after-signup',
  templateUrl: './after-signup.component.html',
  styleUrls: ['./after-signup.component.css']
})
export class AfterSignupComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  clickGoto=function(){
    this.router.navigateByUrl('/login');
  }; 

}
