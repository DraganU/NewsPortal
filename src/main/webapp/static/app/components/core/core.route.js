(function() {

  'use strict';

  angular
      .module('news-portal.core')
      .config(config);

  config.$inject = ["$stateProvider", "$urlRouterProvider"];

  function config($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/home');

    $stateProvider
        .state('main', {
          abstract: true,
          views: {
            navbar: {
              templateUrl: 'static/app/components/core/navbar.html'
            },
            sidebar: {
              templateUrl: 'static/app/components/core/sidebar.html'
            },
            footer: {
              templateUrl: 'static/app/components/core/footer.html'
            }
          }
        })
        .state('main.about', {
          url: "/about",
          views: {
            "content@": {
              templateUrl: 'static/app/components/core/about.html'
            }
          }
        })


  }

})();
