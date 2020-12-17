import { Component, OnInit } from '@angular/core';
import { FirstServiceService } from '../../services/first-service.service';

@Component({
  selector: 'app-bestall',
  templateUrl: './bestall.component.html',
  styleUrls: ['./bestall.component.css']
})
export class BestAllComponent implements OnInit {

  joke1: String;

  constructor(private FirstService: FirstServiceService) { }

  ngOnInit(): void {
    this.FirstService.best0().subscribe((open) => {
      this.joke1 = open;
    });

      
  }

}
