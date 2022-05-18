import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = "hola"
  password = ""
  errorMessage ="Invalid credentials"
  invalidLogin = false

  //by default Angular constructor params (router) as a property
  constructor(private router: Router, private hardcodedAuthenticationService: HardcodedAuthenticationService) {
    
  }

  ngOnInit(): void {
  }

  handleLogin(){
    if(this.hardcodedAuthenticationService.authenticate(this.username, this.password)){
      this.router.navigate(["welcome", this.username])      //redirect to welcome page
      this.invalidLogin=false
    }else
      this.invalidLogin=true
  }

}
