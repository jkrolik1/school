import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor( ) {}

  fact: String;
  number: String;

  ngOnInit(): void {
      fetch("https://numbersapi.p.rapidapi.com/random/trivia?fragment=true&min=10&json=true", {
        "method": "GET",
        "headers": {
          "x-rapidapi-key": "62bdc44994msh57dde2e5f8a8b5ap1667d8jsn409fb57906f6",
          "x-rapidapi-host": "numbersapi.p.rapidapi.com"
        }
      })
      .then(response => response.json())
      .then(data => {
        this.number = data.number;
        this.fact = data.text;
      });
    }
}

