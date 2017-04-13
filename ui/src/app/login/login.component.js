import templateUrl from './login.component.html'

/* @ngInject */
class LoginController {
  loggedIn = false
  showMessage = false
  credentials = {
    username: '',
    password: ''
  }

  constructor (userService, validateService) {
    this.userService = userService
    this.validateService = validateService
  }

  login (username, password) {
    if (username !== undefined && password !== undefined) {
      this.credentials.username = username
      this.credentials.password = password
      this.validateService.validateCredentials(this.credentials)
        .then(data => {
          if (data === true) {
            this.userService.currentUser = this.credentials
            this.showMessage = false
            this.loggedIn = true
          } else {
            this.showMessage = true
          }
        })
    }
  }
}

export default {
  templateUrl,
  controller: LoginController,
  controllerAs: 'loginCtrl'
}
