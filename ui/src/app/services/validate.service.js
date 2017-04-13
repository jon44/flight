/* @ngInject */
class ValidateService {
  constructor ($http, apiUrl) {
    this.$http = $http
    this.apiUrl = apiUrl
  }

  validateUsernameAvailable (username) {
    return this.$http
      .get(`${this.apiUrl}/validate/available/${username}`)
      .then(result => result.data)
  }

  validateUsernameExists (username) {
    return this.$http
      .get(`${this.apiUrl}/validate/exists/${username}`)
      .then(result => result.data)
  }

  validateCredentials (credentials) {
    return this.$http
      .post(`${this.apiUrl}/validate/valid`, JSON.stringify(credentials))
      .then(result => {
        return result.data
      })
  }
}

export default ValidateService
