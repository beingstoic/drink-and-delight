import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginLogoutService } from '../services/login.logout.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private service:LoginLogoutService,private router:Router){}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    
      if(this.service.loggedIn()){
        return true;
      }
      else{
        this.router.navigate(['/login'],{queryParams:{returnUrl:state.url}});
        return false;
      }
  }
  
}
