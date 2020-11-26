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

  removeAll(): void{
    let list: string[] = JSON.parse(localStorage.getItem('todolist'));
    list.splice(0,list.length);
    localStorage.setItem('todolist',JSON.stringify(list));
  } 

  delete(index: number): void{
    let list: string[] = JSON.parse(localStorage.getItem('todolist'));
    list.splice(index,1);
    localStorage.setItem('todolist',JSON.stringify(list));
  }
}
