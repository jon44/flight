import flightMap from './map/map.module'
import flightsList from './layout/flights/flights.module'
import apiUrl from './api.url'
import appComponent from './app.component.js'

export default
  angular
    .module('flight', [
      'ngAria',
      'ngAnimate',
      'ngMaterial',
      'ngMessages',
      'ui.router',

      flightMap,
      flightsList
    ])
    .constant('apiUrl', apiUrl)
    .component('flightApp', appComponent)
    .name
