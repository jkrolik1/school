import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  listX = [];

  onAdd(name){
    this.listX.push(name);
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

}

// przy kazdej pozycji przycisk do usuwania tej pozycji
// przy kazdej pozycji done ? jest przekreslane, jest w liscie zrobionych itd
// zeby po wcisnieciu klawisza tez bylo podswietlone
