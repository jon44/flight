/* @ngInject */
class FlightsService {
  constructor ($http, apiUrl) {
    this.$http = $http
    this.apiUrl = apiUrl
  }

  getFlights () {
    return this.$http
      .get(`${this.apiUrl}/flights`)
      .then(result => result.data)
  }
}

export default FlightsService
