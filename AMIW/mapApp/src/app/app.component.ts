import { Component } from '@angular/core';

declare let ol: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  map: any;

  ngOnInit() {
    this.map = new ol.Map({
      "target": "map",
      layers: [
        new ol.layer.Tile({
          source: new ol.source.OSM()
        })
      ],
      view: new ol.View({
        center: ol.proj.fromLonLat([39, 50]),
        zoom: 4
      })
    });
  }
}
// Nowe api???
// Nakładanie znaczników, warstwy, dymki (https://openlayers.org/en/latest/doc/quickstart.html)
// Nałożenie zanieczyszczenia powietrza itd, śnieg, kropki
// https://openweathermap.org/current#current_JSON