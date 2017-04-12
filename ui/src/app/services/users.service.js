angular.module('flight')

.service('userService', function ($http) {
  this.currentUser = {
    username: '',
    password: ''
  }

  this.getCurrentUser = () => { return this.currentUser }

  this.setCurrentUser = (currentUser) => { this.currentUser = currentUser }

  this.postUser = (user) => {
    return $http.post(`http://localhost:8000/users/`, JSON.stringify(user))
        .then(function success (response) {
          this.currentUser = user['credentials']
          return response.data
        })
  }

  this.getUser = (username) => {
    return $http.get(`http://localhost:8000/users/${username}`)
      .then(function success (response) {
        return response.data
      })
  }
})
