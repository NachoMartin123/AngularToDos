import { HttpInterceptorBasicAuthService } from './service/http/http-interceptor-basic-auth.service';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { ListToDosComponent } from './list-to-dos/list-to-dos.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { LogoutComponent } from './logout/logout.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TodoComponent } from './todo/todo.component';
import { PortadaComponent } from './portada/portada.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    WelcomeComponent,
    ErrorComponent,
    ListToDosComponent,
    MenuComponent,
    FooterComponent,
    LogoutComponent,
    TodoComponent,
    PortadaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    HttpClientModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, 
      useClass: HttpInterceptorBasicAuthService, 
      multi:true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
