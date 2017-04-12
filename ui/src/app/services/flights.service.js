/* @ngInject */
class FlightsService {
  constructor ($http) {
    this.$http = $http
  }

  getFlights () {
    return this.$http
      .get(`http://localhost:8000/flights`)
      .then(result => result.data)
  }
}

export default FlightsService
