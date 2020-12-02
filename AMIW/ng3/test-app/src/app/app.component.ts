import { Component } from '@angular/core';
import { TodoService } from './todo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  todos = []
  
  constructor(private todoService: TodoService) { }

  onAdd(name: string){
    this.todoService.addToDo(name);
  }

  onClear(){
    this.todoService.removeAll();
  }

}

