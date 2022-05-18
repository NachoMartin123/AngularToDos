import { HardcodedAuthenticationService } from './hardcoded-authentication.service';
import { CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot, Router } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate{

  constructor(
    private hardcodedAuthenticationService: HardcodedAuthenticationService,
    private router:Router ) {

   }


  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.hardcodedAuthenticationService.isUserLoggedIn())
        return true;

    this.router.navigate(["login"]);

    return false;
  }

}
