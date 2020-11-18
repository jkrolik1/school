import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  name: any;
  //listX = [];

  onAdd(event){
    //this.name = event.target.value;
    //this.listX.push(name);
    if(event.key === "Enter"){
      console.log(event.target.value);
    }
  }
}
