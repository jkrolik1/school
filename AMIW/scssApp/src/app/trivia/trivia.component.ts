import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-trivia',
  templateUrl: './trivia.component.html',
  styleUrls: ['./trivia.component.scss']
})
export class TriviaComponent implements OnInit {

  constructor() { }

  fact: String;
  number: String;

  ngOnInit(): void {
      fetch("https://numbersapi.p.rapidapi.com/42/trivia?fragment=true&notfound=floor&json=true", {
        "method": "GET",
        "headers": {
          "x-rapidapi-key": "62bdc44994msh57dde2e5f8a8b5ap1667d8jsn409fb57906f6",
          "x-rapidapi-host": "numbersapi.p.rapidapi.com"
        }
      })
      .then(response => response.json())
      .then(data => {
        this.number = data.number;
        console.log(data);
        this.fact = data.text;
      });
    }
}
