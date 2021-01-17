import { Component } from '@angular/core';
import {OSM, Vector as VectorSource} from 'ol/source';
import {Point} from 'ol/geom';
import {Tile as TileLayer, Vector as VectorLayer} from 'ol/layer';
import {Feature, Map, View} from 'ol/index';
import { fromLonLat } from 'ol/proj';
import {createStringXY} from 'ol/coordinate';
import MousePosition from 'ol/control/MousePosition';
import {defaults as defaultControls} from 'ol/control';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  map: Map;
  link: RequestInfo;
  weather: String;
  vectorLayer: VectorLayer;
  mousePositionControl: MousePosition;
  len1old: DoubleRange;
  len2old: DoubleRange;
  layer1: VectorLayer;
  iconPath: String;

  constructor() { }

  ngOnInit(){
    this.mousePositionControl = new MousePosition({
      coordinateFormat: createStringXY(4),
      projection: 'EPSG:4326',
    });
    this.getAPI(21,52);
    this.createMap(21,52);
  }

  newPoint(l1,l2){
    if (this.vectorLayer)
      this.map.removeLayer(this.vectorLayer);
    this.map.removeLayer(this.layer1);
    var point: any = new Point(fromLonLat([l1, l2]));
    this.layer1 = (new VectorLayer({
      source: new VectorSource({
        features: [new Feature(point)],
      }),
    }));
    this.map.addLayer(this.layer1);
  }

  newCenter(l1,l2){
    this.map.getView().setCenter(fromLonLat([l1, l2]));
  }

  createMap(l1,l2) {
    var point: any = new Point(fromLonLat([l1, l2]));
    this.vectorLayer = new VectorLayer({
      source: new VectorSource({
        features: [new Feature(point)],
      }),
    });
    this.map = new Map({
      controls: defaultControls().extend([this.mousePositionControl]),
      layers: [
        new TileLayer({
          source: new OSM(),
        }), 
        this.vectorLayer,
      ],
      target: 'map',
      view: new View({
        center: fromLonLat([l1, l2]),
        zoom: 5,
      }),
    });
  }

  getAPI(l1,l2){
    this.link = "http://api.openweathermap.org/data/2.5/weather?lat=" + l1 + "&lon=" + l2 + "&&APPID=3300e901023b082fd1c9ab305058add4";
    fetch(this.link)
    .then(response => response.json())
    .then(data => {
      var j = data;
      this.weather = (j.weather[0].main) + ", ";
      this.weather += (j.weather[0].description);
      this.iconPath = "http://openweathermap.org/img/w/" + j.weather[0].icon + ".png";
    });
  }

  onAdd(len1,len2){
    this.getAPI(len1,len2);
    this.newPoint(len1,len2);
    this.newCenter(len1,len2);
  }
}