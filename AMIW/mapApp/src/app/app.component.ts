import { Component } from '@angular/core';
import { MapServiceService} from '../app/services/map-service.service'
import MousePosition from 'ol/control/MousePosition';
import {OSM, Vector as VectorSource} from 'ol/source';
import {Point} from 'ol/geom';
import {createStringXY} from 'ol/coordinate';
import {defaults as defaultControls} from 'ol/control';
import {Tile as TileLayer, Vector as VectorLayer} from 'ol/layer';
import {useGeographic} from 'ol/proj';
import {Feature, Map, View} from 'ol/index';

useGeographic();


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  map: any;
  place: any = [21.012229, 52.229676];
  point: any = new Point(this.place);
  
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
    this.map = new Map({
      controls: defaultControls().extend([this.mousePositionControl]),
      layers: [
        new TileLayer({
          source: new OSM(),
        }), 
        new VectorLayer({
          source: new VectorSource({
            features: [new Feature(this.point)],
          }),
        }),
      ],
      target: 'map',
      view: new View({
        center: this.place,
        zoom: 5,
      }),
    });
    this.MapService.getAPI().subscribe((open) => {
      this.point = open;
    });
    

  }

}