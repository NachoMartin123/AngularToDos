import { BasicAuthenticationService } from './../service/basic-authentication.service';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = "in28minutes"
  password = ""
  errorMessage ="Invalid credentials"
  invalidLogin = false

  //by default Angular constructor params (router) as a property
  constructor(
    private router: Router, 
    //private hardcodedAuthenticationService: HardcodedAuthenticationService,
    private basicAuthenticationService: BasicAuthenticationService
  ) { }

  ngOnInit(): void {
  }

  /* handleLogin(){
    if(this.hardcodedAuthenticationService.authenticate(this.username, this.password)){
      this.router.navigate(["welcome", this.username])      //redirect to welcome page
      this.invalidLogin=false
    }else
      this.invalidLogin=true
  } */

  handleBasicAuthLogin(){
    this.basicAuthenticationService.executeAuthenticationService(this.username, this.password)
      .subscribe(
        data => {
          console.log(data);
          this.router.navigate(["welcome", this.username])      //redirect to welcome page
          this.invalidLogin=false
        },
        error => {
          console.log(error);
          this.invalidLogin=true
        }
      )
  }

}
