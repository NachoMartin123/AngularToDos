import { TodoComponent } from './todo/todo.component';
import { RouteGuardService } from './service/route-guard.service';
import { LogoutComponent } from './logout/logout.component';
import { ListToDosComponent } from './list-to-dos/list-to-dos.component';
import { ErrorComponent } from './error/error.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


//1 - add object to Routes
const routes: Routes = [
	{path: "login", component: LoginComponent},
	//url disponible si cumple la condicion de canActivate
	{path: "welcome/:name", component: WelcomeComponent, canActivate:[RouteGuardService]},
	{path: "toDos", component: ListToDosComponent, canActivate:[RouteGuardService]},
	{path: "logOut", component: LogoutComponent, canActivate:[RouteGuardService]},
	{path: "toDos/:id", component: TodoComponent, canActivate:[RouteGuardService]},
	
	{path: "**", component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
