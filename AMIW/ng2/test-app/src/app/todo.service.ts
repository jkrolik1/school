import { Injectable } from '@angular/core';
import { of } from 'rxjs/internal/observable/of';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private todos = ['a','b','c'];

  constructor() {}

  getTodos(){
    return of(this.todos);
  }

  addToDo(todo: string){
    this.todos.push(todo);
  }

  removeAll(){
    this.todos.splice(0,this.todos.length);
  }
}
