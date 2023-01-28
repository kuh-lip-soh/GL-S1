import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment'
import { SAVED_ACTIVITIES } from '../shared/activities';

var apiToken = environment.MAPBOX_API_KEY;
declare var omnivore: any;
declare var L: any;

const defaultCoords: number[]= [40,-80]
const defaultZoom: number = 8

@Injectable()
export class MapService {

  constructor() { }

  getActivity(id: number){
    return SAVED_ACTIVITIES.slice(0).find(run => run.id == id)
  }

  plotActivity(id: number){
    var Style = {
      "color": "#25b04a",
      "weight": 5,
      "opacity": 0.90
    };

    var map = L.map('map').setView(defaultCoords, defaultZoom);

    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{tileSize}/{z}/{x}/{y}?access_token={accessToken}', {
      maxZoom: 18,
      id: 'mapbox/navigation-night-v1',
      tileSize: 256,
      accessToken: apiToken
    }).addTo(map);

    var customLayer = L.geoJson(null, {
      style: Style
    });

    var gpxLayer = omnivore.gpx(SAVED_ACTIVITIES.slice(0).find(run => run.id == id)?.gpxData, null, customLayer).on('ready', function() {
      map.fitBounds(gpxLayer.getBounds());
    }).addTo(map);

  }
  
}
