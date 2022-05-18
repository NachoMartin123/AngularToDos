import { WelcomeDataService, HelloWorldBean } from './../service/data/welcome-data.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  name = ""
  welcomeMessageFromString: string =""

  //ActivatedRoute para obtener parametros en URLs
  constructor(
    private route:ActivatedRoute,
    private welcomeDataService: WelcomeDataService) {

  }

  ngOnInit(): void {
	  this.name = this.route.snapshot.params["name"]
    console.log(this.name);
  }

  getWelcomeMessage(){
    //console.log(this.welcomeDataService.executeHelloWorldBeanService());
    this.welcomeDataService.executeHelloWorldBeanService().subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }

  getWelcomeMessageWithParameter(){
    //console.log(this.welcomeDataService.executeHelloWorldBeanService());
    this.welcomeDataService.executeHelloWorldBeanServicWithPathVariable(this.name).subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }

  handleSuccessfulResponse(response:any){
    this.welcomeMessageFromString = response.message
  }

  handleErrorResponse(error: any){
    this.welcomeMessageFromString = error.error.message
  }

  

}
