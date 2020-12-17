import { Component, OnInit } from '@angular/core';
import { FirstServiceService } from './../../services/first-service.service';

@Component({
  selector: 'app-second',
  templateUrl: './second.component.html',
  styleUrls: ['./second.component.css']
})
export class SecondComponent implements OnInit {

  joke2: String;

  constructor(private FirstService: FirstServiceService) { }

  ngOnInit(): void {
    this.FirstService.best2().subscribe((open) => {
      this.joke2 = open;
    });
  }
}
