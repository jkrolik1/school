import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  listX = ['a','b','c'];

  onAdd(name){
    this.listX.push(name);
  }

  onClear(){
    this.listX = [];
  }

}

