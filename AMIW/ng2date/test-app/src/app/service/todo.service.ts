import { Injectable } from '@angular/core';
import * as moment from 'moment';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TodoService {
  openTasks = [];
  doneTasks = [];

  constructor() {}

  findAll() {
    if (localStorage.getItem('todoOpenTasks') === null) {
      this.openTasks = [];
    } else {
      this.openTasks = JSON.parse(localStorage.getItem('todoOpenTasks'));
    }
    return of(this.openTasks);
  }

  findAll2() {
    if (localStorage.getItem('todoDoneTasks') === null) {
      this.doneTasks = [];
    } else {
      this.doneTasks = JSON.parse(localStorage.getItem('todoDoneTasks'));
    }
    return of(this.doneTasks);
  }

  add(task: { title: any; date: string; }): void {
    this.openTasks.push({
      title: task.title,
      date: new Date(),
    });
    localStorage.setItem('todoOpenTasks', JSON.stringify(this.openTasks));
  }

  done(index: number): void {
    const title: { title: string; date: string } = this.openTasks[index];
    this.openTasks.splice(index, 1);
    localStorage.setItem('todoOpenTasks', JSON.stringify(this.openTasks));

    if (localStorage.getItem('todoDoneTasks') == null) {
      this.doneTasks.push(title);
      localStorage.setItem('todoDoneTasks', JSON.stringify(this.doneTasks));
    } else {
      this.doneTasks.push(title);
      localStorage.setItem('todoDoneTasks', JSON.stringify(this.doneTasks));
    }
  }

  undone(index: number): void {
    const title: { title: string; date: string } = this.doneTasks[index];
    this.doneTasks.splice(index, 1);
    localStorage.setItem('todoDoneTasks', JSON.stringify(this.doneTasks));

    if (localStorage.getItem('todoOpenTasks') == null) {
      this.openTasks.push(title);
      localStorage.setItem('todoOpenTasks', JSON.stringify(this.openTasks));
    } else {
      this.openTasks.push(title);
      localStorage.setItem('todoOpenTasks', JSON.stringify(this.openTasks));
    }
  }

  removeAll(): void {
    this.openTasks.splice(0, this.openTasks.length);
    localStorage.setItem('todoOpenTasks', JSON.stringify(this.openTasks));

    this.doneTasks.splice(0, this.doneTasks.length);
    localStorage.setItem('todoDoneTasks', JSON.stringify(this.doneTasks));
  }

  delete(index: number): void {
    this.openTasks.splice(index, 1);
    localStorage.setItem('todoOpenTasks', JSON.stringify(this.openTasks));
  }
  delete2(index: number): void {
    this.doneTasks.splice(index, 1);
    localStorage.setItem('todoOpenTasks', JSON.stringify(this.doneTasks));
  }

  goUp(index: number): void {
    const title: { title: string; date: string } = this.openTasks[index];
    this.openTasks.splice(index, 1);
    this.openTasks.unshift(title);
    localStorage.setItem('todoOpenTasks', JSON.stringify(this.openTasks));
  }
}
