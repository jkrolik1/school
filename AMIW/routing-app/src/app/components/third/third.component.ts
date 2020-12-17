import { Component, OnInit } from '@angular/core';
import { FirstServiceService } from './../../services/first-service.service';

@Component({
  selector: 'app-third',
  templateUrl: './third.component.html',
  styleUrls: ['./third.component.css']
})
export class ThirdComponent implements OnInit {

  joke3: String;

  constructor(private FirstService: FirstServiceService) { }

  ngOnInit(): void {
    this.FirstService.best3().subscribe((open) => {
      this.joke3 = open;
    });
  }

}
