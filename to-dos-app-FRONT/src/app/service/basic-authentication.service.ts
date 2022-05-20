import { API_URL } from './../../app.constants';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {map} from "rxjs/operators";

export const TOKEN = "token"
export const AUTHENTICATED_USER = "authenticatedUser" 

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {

  constructor(private http:HttpClient) { }

  executeAuthenticationService(username: any, password:any){
    //window.btoa == encrypt in javascript format
    let basicAuthHeaderString= "Basic "+window.btoa(username+":"+password);

    let header = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })
    
    return this.http.get<AuthenticationBean>(
      `${API_URL}/basicauth`,
      {headers: header}).pipe(//pipe== waht to do after get result
        map(
          data => {
            sessionStorage.setItem(AUTHENTICATED_USER, username);
            sessionStorage.setItem(TOKEN, basicAuthHeaderString);
            return data;
          }
        )
      );
  }

  getAuthenticatedUser(){
    return sessionStorage.getItem(AUTHENTICATED_USER);
  }

  getAuthenticatedToken(){
    if(this.getAuthenticatedUser())
        return sessionStorage.getItem(TOKEN);
    return "";
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem(AUTHENTICATED_USER);
    return !(user==null)//null == not logged
  }

  logOut(){
	  sessionStorage.removeItem(AUTHENTICATED_USER);
    sessionStorage.removeItem(TOKEN);
  }

}


export class AuthenticationBean {

  constructor(public message: string){}

}