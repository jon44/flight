import flightMap from './map/map.module'
import flightsList from './layout/flights/flights.module'
import login from './login/login.module'
import register from './layout/register/register.module'
import flightsearch from './layout/flightsearch/flightsearch.module'
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
      flightsList,
      login,
      register,
      flightsearch
    ])
    .constant('apiUrl', apiUrl)
    .component('flightApp', appComponent)
    .name
