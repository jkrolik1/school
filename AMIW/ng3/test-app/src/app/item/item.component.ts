import { Component, OnInit } from '@angular/core';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  constructor(private todoService: TodoService) { }
  
  ngOnInit(): void {
    this.todoService.getTodos().subscribe( todos => {
      this.todos = todos;
    });
  }

  todos = []

}
