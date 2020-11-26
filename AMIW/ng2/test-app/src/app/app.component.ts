import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms'
import { TodoService } from './todo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  
  todoForm: FormGroup;
  todos: string[];

  constructor(
    private todoService: TodoService,
    private FormBuilder: FormBuilder
  ) { }

  ngOnInit(){
    this.todoForm = this.FormBuilder.group({
      title: ['',[Validators.required]]
    });    
    this.todos = this.todoService.findAll();
  }

  add(): void{
    this.todoService.add(this.todoForm.value.title);
    this.todos = this.todoService.findAll();
  }

/*   onAdd(name: string){
    this.todoService.addToDo(name);
  }

  onClear(){
    this.todoService.removeAll();
  } */

}

