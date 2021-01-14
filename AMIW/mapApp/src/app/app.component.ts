import { Component } from '@angular/core';
import { MapServiceService} from '../app/services/map-service.service'
import MousePosition from 'ol/control/MousePosition';
import Map from 'ol/Map';
import OSM from 'ol/source/OSM';
import TileLayer from 'ol/layer/Tile';
import View from 'ol/View';
import {createStringXY} from 'ol/coordinate';
import {defaults as defaultControls} from 'ol/control';

declare let ol: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  map: any;
  xxx: any;
  
  constructor(private MapService: MapServiceService) { }

  mousePositionControl = new MousePosition({
    coordinateFormat: createStringXY(4),
    projection: 'EPSG:4326',
    // comment the following two lines to have the mouse position
    // be placed within the map.
    className: 'custom-mouse-position',
    target: document.getElementById('mouse-position'),
    undefinedHTML: '&nbsp;',
  });

  ngOnInit() {
    this.map = new ol.Map({
      controls: defaultControls().extend([this.mousePositionControl]),
      layers: [
        new TileLayer({
          source: new OSM(),
        }) ],
      target: 'map',
      view: new View({
        center: ol.proj.fromLonLat([21, 52]),
        zoom: 5,
      }),
    });
    this.MapService.getAPI().subscribe((open) => {
      this.xxx = open;
    });
    

  }

}