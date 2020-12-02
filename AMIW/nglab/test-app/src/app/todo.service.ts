import { Injectable } from '@angular/core';
import * as moment from 'moment';
import { of } from 'rxjs/internal/observable/of';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private todos = [
    {
      "label": "Zadanie przykładowe",
      "date": 211212121
    }
  ];

  constructor() {}

  getTodos(){
    return of(this.todos);
  }

  addToDo(todo: string){
    this.todos.push({
      "label": todo,
      "date": Date.now()
    });
  }

  removeAll(){
    this.todos.splice(0,this.todos.length);
  }
}
