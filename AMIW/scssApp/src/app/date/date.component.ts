import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-date',
  templateUrl: './date.component.html',
  styleUrls: ['./date.component.scss']
})
export class DateComponent implements OnInit {

  constructor() { }

  fact: String;
  number: String;

  ngOnInit(): void {
      fetch("https://numbersapi.p.rapidapi.com/6/21/date?fragment=true&json=true", {
        "method": "GET",
        "headers": {
          "x-rapidapi-key": "62bdc44994msh57dde2e5f8a8b5ap1667d8jsn409fb57906f6",
          "x-rapidapi-host": "numbersapi.p.rapidapi.com"
        }
      })
      .then(response => response.json())
      .then(data => {
        this.number = data.year;
        console.log(data);
        this.fact = data.text;
      });
    }

}
