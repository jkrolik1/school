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
  todos: { title: string; date: string; }[];
  todosDone: { title: string; date: string; }[];

  constructor(
    private todoService: TodoService,
    private FormBuilder: FormBuilder
  ) { }

  ngOnInit(){
    this.todoForm = this.FormBuilder.group({
      title: ['',[Validators.required]]
    });    
    this.todos = this.todoService.findAll();
    this.todosDone = this.todoService.findAll2();
  }

  add(): void{
    this.todoService.add(this.todoForm.value.title);
    this.todos = this.todoService.findAll();
    this.todosDone = this.todoService.findAll2();
    this.todoForm.reset();
  }

 removeAll(): void{
    var result = confirm("Czy jesteś pewien?");
    if(result){
      this.todoService.removeAll();
      this.todos = this.todoService.findAll();
      this.todosDone = this.todoService.findAll2();
    }
  } 
}

