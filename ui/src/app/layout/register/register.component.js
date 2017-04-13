import templateUrl from './register.component.html'

/* @ngInject */
class RegisterController {
  credentials = {
    username: '',
    password: ''
  }

  profile = {
    firstName: '',
    lastName: '',
    email: '',
    phone: ''
  }

  usernameRequired = false
  usernameTaken = false
  passwordRequired = false
  emailRequired = false

  constructor (userService, validateService) {
    this.userService = userService
    this.validateService = validateService
  }

  register (username, password, firstName, lastName, email, phone) {
    username === undefined ? this.usernameRequired = true : this.usernameRequired = false
    password === undefined ? this.passwordRequired = true : this.passwordRequired = false
    email === undefined ? this.emailRequired = true : this.emailRequired = false

    if (username !== undefined) {
      this.validateService.validateUsernameAvailable(username)
        .then((data) => {
          if (data === false) {
            this.usernameTaken = true
          } else {
            this.usernameTaken = false
          }
        })
    }

    if (username !== undefined && password !== undefined && email !== undefined && this.usernameTaken !== true) {
      this.credentials = {username: username, password: password}
      this.profile = {firstName: firstName, lastName: lastName, email: email, phone: phone}
      this.userService.postUser({ credentials: this.credentials, profile: this.profile })
        .then((data) => {
          if (data !== undefined) {
            console.log('post success')
          } else {
            console.log('post failed')
          }
        })
    }
  }
}

export default {
  templateUrl,
  controller: RegisterController,
  controllerAs: 'registerCtrl'
}
