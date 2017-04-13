import loginComponent from './login.component.js'
import userService from 'C:/Users/student-5/flight/ui/src/app/services/users.service.js'
import validateService from 'C:/Users/student-5/flight/ui/src/app/services/validate.service.js'

export default
  angular
    .module('flight.map')
    .component('login', loginComponent)
    .service('userService', userService)
    .service('validateService', validateService)
    .name
