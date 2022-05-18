import { ActivatedRoute } from '@angular/router';
import { ToDoDataService } from './../service/data/to-do-data.service';
import { Component, OnInit } from '@angular/core';
import { ToDo } from '../list-to-dos/list-to-dos.component';
import {Router} from "@angular/router";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  id:number
  toDo:ToDo

  constructor(
    private toDoService: ToDoDataService,
    private route:ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params["id"]
   
    this.toDo = new ToDo(this.id, "", false, new Date())

    if(this.id!=-1){
      this.toDoService.retrieveToDo("hola", this.id).subscribe(
        data => this.toDo = data
      )
    }
  }

  saveToDo(){
    if(this.id === -1){
        //create ToDo
        this.toDoService.createToDo("hola", this.toDo).subscribe(
            data => {
                console.log(data);
                this.router.navigate(["toDos"])
            }
        )
    }else{
        //update if exists
        this.toDoService.updateToDo("hola", this.id, this.toDo).subscribe(
            data => {
                console.log(data);
                this.router.navigate(["toDos"])
            }
        )
    }
  }

}
