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

  constructor (userService) {
    this.userService = userService
  }

  register (username, password, firstName, lastName, email, phone) {
    console.log(username)
  }

  // postUser () {
  //   return () => {
  //     this.flightService.getFlights()
  //     .then(data => {
  //       this.flights = data
  //     })
  //   }
  // }

}

export default {
  templateUrl,
  controller: RegisterController,
  controllerAs: 'registerCtrl'
}
