import flightsComponent from './flights.component.js'
import flightsService from 'C:/Users/student-5/flight/ui/src/app/services/flights.service.js'

export default
  angular
  .module('flight.map')
  .component('flightsList', flightsComponent)
  .service('flightService', flightsService)
  .name
