import { Component } from '@angular/core';
import * as moment from 'moment';
import { TodoService } from './todo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  private todos = [
    {
      "label": "Zadanie przykładowe",
      "date": moment().toDate()
    }
  ];

  
  constructor(private todoService: TodoService) { }

  ngOnInit(){
    this.todoService.getTodos().subscribe( todos => {
      this.todos = todos;
    });
  }

  onAdd(name: string){
    this.todoService.addToDo(name);
  }

  onClear(){
    this.todoService.removeAll();
  }

}

