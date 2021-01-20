import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-year',
  templateUrl: './year.component.html',
  styleUrls: ['./year.component.scss']
})
export class YearComponent implements OnInit {

  constructor() { }
  fact: String;
  number: String;

  ngOnInit(): void {
      fetch("https://numbersapi.p.rapidapi.com/1492/year?fragment=true&json=true", {
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
