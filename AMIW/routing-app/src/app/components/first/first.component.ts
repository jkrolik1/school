import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {

  joke: any;

  constructor() { }

  ngOnInit(): void {
    fetch('https://api.jokes.one/jod')
    .then(response => response.json())
    .then(data => {
      var joke = data.contents.jokes[0].joke.text;
      this.joke = joke;
    });
      
  }

}
