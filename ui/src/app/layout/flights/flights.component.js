import templateUrl from './flights.component.html'

/* @ngInject */
class FlightsController {
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
  controller: FlightsController,
  controllerAs: 'flightsCtrl'
}
