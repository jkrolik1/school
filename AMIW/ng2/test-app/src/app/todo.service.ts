import { Injectable } from '@angular/core';
import { of } from 'rxjs/internal/observable/of';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor() {}

  findAll(): string[]{
    if (localStorage.getItem('todolist') != null) {
      return JSON.parse(localStorage.getItem('todolist'));
    }
    return null;
  }

  add(title: string): void {
    if (localStorage.getItem('todolist') == null) {
      let list: string[] = [];
      list.push(title);
      localStorage.setItem('todolist',JSON.stringify(list));
    } else {
      let list: string[] = JSON.parse(localStorage.getItem('todolist'));
      list.push(title);
      localStorage.setItem('todolist',JSON.stringify(list));
    }
  }

/*   addToDo(todo: string){
    this.todos.push(todo);
  }

  removeAll(){
    this.todos.splice(0,this.todos.length);
  } */
}
