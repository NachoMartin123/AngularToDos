import { ToDo } from './../../list-to-dos/list-to-dos.component';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TO_DO_JPA_API_URL } from 'src/app.constants';

@Injectable({
  providedIn: 'root'
})
export class ToDoDataService {

  constructor(private http:HttpClient) {  }

  retrieveAllToDos(username:string){
    return this.http.get<ToDo[]>(`${TO_DO_JPA_API_URL}/users/${username}/toDos`);
  }

  deleteToDo(username: string, id:number){
    return this.http.delete(`${TO_DO_JPA_API_URL}/users/${username}/toDos/${id}`)
  }

  retrieveToDo(username: string, id:number){
    return this.http.get<ToDo>(`${TO_DO_JPA_API_URL}/users/${username}/toDos/${id}`)
  }

  updateToDo(username: string, id:number, toDo:ToDo){
    return this.http.put(`${TO_DO_JPA_API_URL}/users/${username}/toDos/${id}`, toDo)
  }

  createToDo(username: string, toDo:ToDo){
    return this.http.post(`${TO_DO_JPA_API_URL}/users/${username}/toDos`, toDo)
  }

}
