import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {

  constructor() { }

  authenticate(username: any, password:any){
    //console.log("before isLogged? "+this.isUserLoggedIn());
    if(username=="hola" && password==="hola"){
      sessionStorage.setItem("authenticatedUser", username)
      //check in Inspeccionar/Application/Session Storage/http:localhost:4200
      //console.log("after isLogged? "+this.isUserLoggedIn());
      return true;
    }else
      return false;  
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem("authenticatedUser");
    return !(user==null)//null == not logged
  }

  logOut(){
	sessionStorage.removeItem("authenticatedUser");
  }

}
