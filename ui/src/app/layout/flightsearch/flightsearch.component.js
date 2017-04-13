import templateUrl from './flightsearch.component.html'

/* @ngInject */
class FlightSearchController {
  showFlights = true

  flights = []

  endpoints = {
    origin: '',
    destination: ''
  }

  itineraryFound = false

  itinerary = {
    flightTime: '',
    flights: [],
    id: '',
    layover: '',
    users: []
  }

  itineraries = []

  credentials = {
    username: 'jon44',
    password: 'dewsta44'
  }

  bookingRequest = {
    credentials: this.credentials,
    itinerary: this.itinerary
  }

  constructor (userService, flightService, $interval) {
    this.userService = userService
    this.flightService = flightService
    this.$interval = $interval

    $interval(this.getFlights(), 1000)
    $interval(this.updateItinerary(), 1000)
  }

  getFlights () {
    return () => {
      this.flightService.getFlights()
      .then(data => {
        this.flights = data
      })
    }
  }

  updateItinerary () {
    return () => {
      this.flightService.getItinerary(this.endpoints)
      .then(data => {
        if (data !== '') {
          this.itineraryFound = true
          this.itinerary = data
        } else {
          this.itineraryFound = false
        }
      })
    }
  }

  findItinerary (origin, destination) {
    if (origin !== undefined && destination !== undefined) {
      this.showFlights = false
      this.endpoints.origin = origin
      this.endpoints.destination = destination
      this.flightService.getItinerary(this.endpoints)
      .then(data => {
        if (data !== '') {
          this.itineraryFound = true
          this.itinerary = data
        } else {
          this.itineraryFound = false
        }
      })
    }
  }

  bookItinerary () {
    this.bookingRequest.itinerary = this.itinerary
    this.userService.bookItinerary(this.bookingRequest, this.credentials.username)
    .then(data => {
      this.getItineraries()
    })
  }

  getItineraries () {
    this.userService.getItineraries(this.credentials.username)
    .then(data => {
      console.log(data)
      this.itineraries = data
      console.log(this.itineraries)
    })
  }

}

export default {
  templateUrl,
  controller: FlightSearchController,
  controllerAs: 'flightsearchCtrl'
}
