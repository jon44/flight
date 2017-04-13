import templateUrl from './flightsearch.component.html'

/* @ngInject */
class FlightSearchController {
  showFlights = true
  flights = []

  constructor (flightService, $interval) {
    this.flightService = flightService
    this.$interval = $interval

    $interval(this.getFlights(), 1000)
  }

  getFlights () {
    return () => {
      this.flightService.getFlights()
      .then(data => {
        this.flights = data
      })
    }
  }

}

export default {
  templateUrl,
  controller: FlightSearchController,
  controllerAs: 'flightsearchCtrl'
}
