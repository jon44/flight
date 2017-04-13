import registerComponent from './register.component.js'
import userService from 'C:/Users/student-5/flight/ui/src/app/services/users.service.js'

export default
  angular
  .module('flight.map')
  .component('register', registerComponent)
  .service('userService', userService)
  .name
