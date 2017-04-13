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

  getItinerary (endpoints) {
    return this.$http
      .post(`${this.apiUrl}/flights/paths`, JSON.stringify(endpoints))
      .then(result => result.data)
  }
}

export default FlightsService
