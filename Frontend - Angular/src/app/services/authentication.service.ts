/*if the authentication for the user entered username and password is successful, 
we will be saving the JSON Web Token which we are adding the Authorization Header for JWT Authentication in the session.*/
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

export class User{
  constructor(
    public status:string,
     ) {}
  
}

export class JwtResponse{
  constructor(
    public jwttoken:string,
     ) {}
  
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  
  loggedIn() {
    throw new Error("Method not implemented.");
  }

  constructor(private httpClient:HttpClient) 
  {}

     authenticate(username, password) {
      return this.httpClient.post<any>('http://localhost:7003/authenticate',{username,password}).pipe(
       map(
         userData => {
          sessionStorage.setItem('username',username);
          let tokenStr= 'Bearer'+ userData.token;
          sessionStorage.setItem('token', tokenStr);
          return userData;
         }
       )
  
      );
    }
}