import { Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FirstServiceService {

  joke = [];
  
  constructor() { }

  disp(){
    fetch('https://api.jokes.one/jod')
    .then(response => response.json())
    .then(data => {
      var j = data.contents.jokes[0].joke.text;
      this.joke[0] = j;
    });
    return of(this.joke);
  }
}
