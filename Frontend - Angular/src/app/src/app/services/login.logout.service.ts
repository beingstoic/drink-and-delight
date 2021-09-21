import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { HeaderComponent } from '../header/header.component';
import {  Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LoginLogoutService {
    
  baseUrl:string;
  baseUrl1:string;
  user: User;
  username: any;
  password: any;
  loggedInStatus;
  subject: Subject<boolean> = new Subject<boolean>();

  constructor(private http:HttpClient, private router:Router) { 
    this.baseUrl=`${environment.baseMwUrl}/register`;
    this.baseUrl1=`${environment.baseMwUrl}/login`;
  }


  addUser(user:User):Observable<User>{
    return this.http.post<User>(this.baseUrl,user);
  }

  loginUser(user:User):Observable<any>{
    let obr=this.http.post<any>(this.baseUrl1,user);
    obr.subscribe(data=>{if(data.token!=null || data.token!=''){this.subject.next(true)}});
  return obr;
  }

  loggedIn():boolean{
    return !!sessionStorage.getItem('token');
  }

  logoutUser() {
    sessionStorage.removeItem('token')
    this.subject.next(false)
    this.router.navigate(['/login'])
  }

  getToken() {
    return sessionStorage.getItem('token')
  }

  isloggedIn() :Observable<boolean>{
    return this.subject.asObservable()
  }

}