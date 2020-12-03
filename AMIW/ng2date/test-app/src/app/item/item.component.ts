import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms'
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  todoForm: FormGroup;
  todos: { title: string; date: string; }[];
  todosDone: { title: string; date: string; }[];

  style2 = {'text-decoration': 'line-through',
            'color': 'rgb(150, 150, 150)'};

  constructor(
    private todoService: TodoService,
    private FormBuilder: FormBuilder
  ) { }

  ngOnInit(){
    this.todos = this.todoService.findAll();
    this.todosDone = this.todoService.findAll2();
  }

  delete(index: number): void{
    var result = confirm("Czy jesteś pewien?");
    if(result){
      this.todoService.delete(index);
      this.todos = this.todoService.findAll();
      this.todosDone = this.todoService.findAll2();
    }
  }
  delete2(index: number): void{
    var result = confirm("Czy jesteś pewien?");
    if(result){
      this.todoService.delete2(index);
      this.todos = this.todoService.findAll();
      this.todosDone = this.todoService.findAll2();
    }
  }

  goUp(index: number): void{
    if(index == 0){
      var result = confirm("Jestem już na górze.");
    }
    this.todoService.goUp(index);
    this.todos = this.todoService.findAll();
    this.todosDone = this.todoService.findAll2();
  }

  done(index: number): void{
    this.todoService.done(index);
    this.todos = this.todoService.findAll();
    this.todosDone = this.todoService.findAll2();
  }

  undone(index: number): void{
    this.todoService.undone(index);
    this.todos = this.todoService.findAll();
    this.todosDone = this.todoService.findAll2();
  }
  

}
