angular.module('flight')

.service('flightService', function ($http) {
  this.currentFlights = []

  this.getFlights = () => {
    return $http.get(`http://localhost:8000/flights/`)
      .then(function success (response) {
        return response.data
      })
  }
})
