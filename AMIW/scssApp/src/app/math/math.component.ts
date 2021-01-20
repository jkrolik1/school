import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-math',
  templateUrl: './math.component.html',
  styleUrls: ['./math.component.scss']
})
export class MathComponent implements OnInit {

  constructor() { }

  fact: String;
  number: String;

  ngOnInit(): void {
      fetch("https://numbersapi.p.rapidapi.com/1729/math?fragment=true&json=true", {
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
