import { Component, OnInit } from '@angular/core';
import { FirstServiceService } from './../../services/first-service.service';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})
export class FirstComponent implements OnInit {

  joke: any[];

  constructor(private FirstService: FirstServiceService) { }

  ngOnInit(): void {
    this.FirstService.disp().subscribe((open) => {
      this.joke = open;
    });

      
  }

}
