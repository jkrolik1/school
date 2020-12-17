import { Component, OnInit } from '@angular/core';
import { FirstServiceService } from './../../services/first-service.service';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {

  joke: String;

  constructor(private FirstService: FirstServiceService) { }

  ngOnInit(): void {
    this.FirstService.best1().subscribe((open) => {
      this.joke = open;
    });

      
  }

}
