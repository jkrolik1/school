import { TodoService } from './../../service/todo.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-new-todo-task',
  templateUrl: './new-todo-task.component.html',
  styleUrls: ['./new-todo-task.component.css'],
})
export class NewTodoTaskComponent implements OnInit {
  todos = {
    title: '',
    date: '',
  };

  constructor(private todoService: TodoService) {}

  ngOnInit(): void {}

  onAdd() {
    if (this.todos.title !== '') {
      this.todoService.add(this.todos);
      this.todos.title = '';
    }
  }

  onRemoveAll() {
    this.todoService.removeAll();
  }
}
