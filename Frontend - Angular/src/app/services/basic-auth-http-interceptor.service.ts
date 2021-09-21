import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
//import { AuthenticationService } from '../services/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthHttpInterceptorService implements HttpInterceptor {

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
     let currentuser=sessionStorage.getItem('username');
     let token=sessionStorage.getItem('token');
    if (sessionStorage.getItem('token')) {
   //   console.log("Inside the interceptor")
    //  req = req.clone({
     //   setHeaders: {
       //   Authorization: `${token}`
       // }
     // })
   //   console.log(req.headers.get('Authorization'));
    }

    return next.handle(req);
  }
}