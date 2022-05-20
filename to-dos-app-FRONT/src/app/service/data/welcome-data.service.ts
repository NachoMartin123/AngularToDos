import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


export class HelloWorldBean {
  constructor(public message: string){}
}

@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(private http:HttpClient) {  }

  //response expected an object with the structure of HelloWorldBean
  executeHelloWorldBeanService(){
    return this.http.get<HelloWorldBean>("http://localhost:8080/hello-world-bean");
  }

  executeHelloWorldBeanServicWithPathVariable(name:string|number){
    let basicAuthHeatherString = this.createBasicAuthenticationHttpHeader();
    
    let header = new HttpHeaders({
      Authorization: basicAuthHeatherString
    })
    
    return this.http.get<HelloWorldBean>(
      `http://localhost:8080/hello-world-bean/path-variable/${name}`,
      {headers: header});
  }

  createBasicAuthenticationHttpHeader(){
    let username = 'in28minutes';
    let password = 'dummy';
    //window.btoa == encrypt in javascript format
    let basicAuthHeaderString= "Basic "+window.btoa(username+":"+password);
  
    return basicAuthHeaderString;
  }

}
