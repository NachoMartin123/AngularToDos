import { ToDoDataService } from './../service/data/to-do-data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

export class ToDo {
  constructor(
    public id : number, public description: string, 
    public done: boolean,  public targetDate: Date
  ){
  }
}

@Component({
  selector: 'app-list-to-dos',
  templateUrl: './list-to-dos.component.html',
  styleUrls: ['./list-to-dos.component.css']
})
export class ListToDosComponent implements OnInit {

  toDos= <ToDo[]>[]
  messageRemoved:string=""

  constructor(
    private toDoDataService:ToDoDataService,
    private router: Router,
    ) { }

  ngOnInit(): void {
    this.refreshToDos();
  }

  deleteToDo(id:number){
    this.toDoDataService.deleteToDo("in28minutes",id).subscribe(
      response => {
        this.messageRemoved = `delete of ToDo ${id} successfull`;
        this.refreshToDos();
      }
    );
  }

  updateToDo(id:number){
    this.router.navigate(["toDos", id]);
   
  }

  refreshToDos(){
    this.toDoDataService.retrieveAllToDos("in28minutes").subscribe(
      response => {
          this.toDos = response;
          console.log(this.toDos);
      }
    );
  }


  addToDo(){
    this.router.navigate(["toDos", -1]);
  }
}
