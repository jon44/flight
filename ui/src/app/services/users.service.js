/* @ngInject */
class UserService {
  currentUser = {
    username: '',
    password: ''
  }

  constructor ($http, apiUrl) {
    this.$http = $http
    this.apiUrl = apiUrl
  }

  getCurrentUser () {
    return this.currentUser
  }

  setCurrentUser (currentUser) {
    this.currentUser = currentUser
  }

  postUser (user) {
    return this.$http
      .post(`${this.apiUrl}/users`, JSON.stringify(user))
      .then(result => {
        this.currentUser = user['credentials']
        return result.data
      })
  }

  getUser (username) {
    return this.$http
      .get(`${this.apiUrl}/users/${username}`)
      .then(result => result.data)
  }
}

export default UserService
