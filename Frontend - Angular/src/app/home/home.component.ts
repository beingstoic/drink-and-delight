import { Component, OnInit } from '@angular/core';
import { LoginLogoutService } from '../services/login.logout.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private logserv:LoginLogoutService) { }

  ngOnInit(): void {
    this.logserv.isloggedIn();
  }

}
