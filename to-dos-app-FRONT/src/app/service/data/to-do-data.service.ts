import { ToDo } from './../../list-to-dos/list-to-dos.component';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ToDoDataService {

  constructor(private http:HttpClient) {  }

  retrieveAllToDos(username:string){
    return this.http.get<ToDo[]>(`http://localhost:8080/users/${username}/toDos`);
  }

  deleteToDo(username: string, id:number){
    return this.http.delete(`http://localhost:8080/users/${username}/toDos/${id}`)
  }

  retrieveToDo(username: string, id:number){
    return this.http.get<ToDo>(`http://localhost:8080/users/${username}/toDos/${id}`)
  }

  updateToDo(username: string, id:number, toDo:ToDo){
    return this.http.put(`http://localhost:8080/users/${username}/toDos/${id}`, toDo)
  }

  createToDo(username: string, toDo:ToDo){
    return this.http.post(`http://localhost:8080/users/${username}/toDos`, toDo)
  }

}
