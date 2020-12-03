import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms'
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  private todoForm: FormGroup;
  private todos: { title: string; date: string; }[];
  private todosDone: { title: string; date: string; }[];

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

}
