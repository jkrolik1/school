import { Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MapServiceService {

  ja: any;
  lat: any = 51;
  lot: any = 21;
  apiLink = "http://api.openweathermap.org/data/2.5/weather?lat=" + this.lat + "&lon=" + this.lot + "&&APPID=3300e901023b082fd1c9ab305058add4";

  constructor() { }

  getAPI(){
    fetch(this.apiLink)
    .then(response => response.json())
    .then(data => {
      var j = data;
      console.log(data.weather);
      this.ja = j;
    });
    return of(this.ja);
  }
}
