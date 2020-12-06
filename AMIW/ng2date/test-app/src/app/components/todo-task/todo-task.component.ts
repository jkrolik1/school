import { TodoService } from './../../service/todo.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todo-task',
  templateUrl: './todo-task.component.html',
  styleUrls: ['./todo-task.component.css'],
})
export class TodoTaskComponent implements OnInit {
  openTasks = [];
  doneTasks = [];
  style2 = { 'text-decoration': 'line-through', color: 'rgb(150, 150, 150)' };

  constructor(private todoService: TodoService) {}

  ngOnInit(): void {
    this.todoService.findAll().subscribe((open) => {
      this.openTasks = open;
    });

    this.todoService.findAll2().subscribe((done) => {
      this.doneTasks = done;
    });
  }

  onGoUp(index: number) {
    this.todoService.goUp(index);
  }

  onDone(index: number) {
    this.todoService.done(index);
  }

  onDelete(index: number) {
    this.todoService.delete(index);
  }

  onUndone(index: number) {
    this.todoService.undone(index);
  }

  onDelete2(index: number) {
    this.todoService.delete2(index);
  }
}
