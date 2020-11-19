import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  listX = [];
  listY = [];

  styleS = {'text-decoration': 'line-through'};

  onAdd(name){
    if (!(name === '')){
      this.listX.push(name);
    }
  }

  onClear(){
    this.listX = [];
    this.listY = [];
  }

  onClearDown(){
    if(this.listY.length == 0){
      this.listX.pop();
    }else{
      this.listY.pop();
    }
    
  }

  onClearUp(){
    if(this.listX.length == 0){
      this.listY.shift();
    }else{
      this.listX.shift();
    }
  }

  onDelete(ele){
    let index = this.listX.findIndex(element => element == ele);
    this.listX.splice(index,1);
  }

  onDone(item){
    let index = this.listX.findIndex(element => element == item);
    this.listY.push(this.listX[index]);
    this.listX.splice(index,1);
  }

  onDelete2(ele){
    let index = this.listX.findIndex(element => element == ele);
    this.listY.splice(index,1);
  }

  onUndone(item2){
    let index = this.listY.findIndex(element => element == item2);
    this.listX.push(this.listY[index]);
    this.listY.splice(index,1);
  }

}

