import { HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
	providedIn: 'root'
})
export class HttpInterceptorBasicAuthService implements HttpInterceptor{

	constructor() { }

	intercept(request: HttpRequest<any>, next: HttpHandler){
		let username = "in28minutes";
		let password = "dummy";
		let basicAuthenticationString= "Basic "+window.btoa(username+":"+password);
	
		request = request.clone({
			setHeaders : {
				Authorization : basicAuthenticationString
			}

		})
		return next.handle(request);
	}
}
