import { TodoService } from './service/todo.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NewTodoTaskComponent } from './components/new-todo-task/new-todo-task.component';
import { TodoTaskComponent } from './components/todo-task/todo-task.component';

@NgModule({
  declarations: [AppComponent, NewTodoTaskComponent, TodoTaskComponent],
  imports: [FormsModule, ReactiveFormsModule, BrowserModule],
  providers: [TodoService],
  bootstrap: [AppComponent],
})
export class AppModule {}
