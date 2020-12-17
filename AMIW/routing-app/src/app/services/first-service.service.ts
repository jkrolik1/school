import { Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FirstServiceService {

  joke: String;
  joke2: String;
  joke3: String;
  joke1: String;
  
  constructor() { }

  best0(){
    fetch('https://api.jokes.one/jod')
    .then(response => response.json())
    .then(data => {
      var j = data.contents.jokes[0].joke.text;
      this.joke1 = j;
    });
    return of(this.joke1);
  }

  best1(){
    fetch('https://api.jokes.one/jod?category=animal')
    .then(response => response.json())
    .then(data => {
      var j = data.contents.jokes[0].joke.text;
      this.joke = j;
    });
    return of(this.joke);
  }

  best2(){
    fetch('https://api.jokes.one/jod?category=blonde')
    .then(response => response.json())
    .then(data => {
      var j = data.contents.jokes[0].joke.text;
      this.joke2 = j;
    });
    return of(this.joke2);
  }

  best3(){
    fetch('https://api.jokes.one/jod?category=knock-knock')
    .then(response => response.json())
    .then(data => {
      var j = data.contents.jokes[0].joke.text;
      this.joke3 = j;
    });
    return of(this.joke3);
  }
}
