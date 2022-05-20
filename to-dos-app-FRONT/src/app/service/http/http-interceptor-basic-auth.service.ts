import { BasicAuthenticationService } from './../basic-authentication.service';
import { HttpHandler, HttpInterceptor, HttpRequest, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
	providedIn: 'root'
})
export class HttpInterceptorBasicAuthService implements HttpInterceptor{

	constructor(
		private basicAuthenticationService:BasicAuthenticationService
	) { }

	intercept(request: HttpRequest<any>, next: HttpHandler){
		let basicAuthHeatherString = this.basicAuthenticationService.getAuthenticatedToken()
		let username = this.basicAuthenticationService.getAuthenticatedUser()

		if(basicAuthHeatherString && username){
			request = request.clone({
				setHeaders : {
					Authorization : basicAuthHeatherString
				}
	
			})
		}
		return next.handle(request);
	}
}
