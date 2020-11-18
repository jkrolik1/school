import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  listX = [];

  onAdd(name){
    if (!(name === '')){
      this.listX.push(name);
    }
    
    console.log(this.listX);
  }

  onClear(){
    this.listX = [];
  }

  onClearDown(){
    this.listX.pop();
  }

  onClearUp(){
    this.listX.shift();
  }

  onDelete(ele){
    let index = this.listX.findIndex(element => element == ele);
    this.listX.splice(index,1);
  }


}

