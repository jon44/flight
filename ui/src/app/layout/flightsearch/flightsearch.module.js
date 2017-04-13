import flightsearchComponent from './flightsearch.component.js'
import flightService from 'C:/Users/student-5/flight/ui/src/app/services/flights.service.js'

export default
  angular
  .module('flight.map')
  .component('flightsearch', flightsearchComponent)
  .service('flightService', flightService)
  .name
