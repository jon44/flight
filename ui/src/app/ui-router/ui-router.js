export default
  angular
    .module('router', ['ui.router'])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
      $urlRouterProvider.otherwise('/home')

      $stateProvider
        .state('home', {
          url: '/home',
          component: 'login'
        })
    }])
