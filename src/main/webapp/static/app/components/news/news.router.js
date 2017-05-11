(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .config(config);

  config.$inject = ["$stateProvider", "$urlRouterProvider"];
  function config($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/news');

    $stateProvider
        .state('main.news', {
          url: "/news",
          views: {
            'content@': {
              templateUrl: 'static/app/components/news/news.html',
              controller: 'NewsController',
              resolve: {
                news: function(NewsService) {
                  return NewsService.getAllnews().then(function(data) {
                    return data;
                  })
                }
              }
            }
          }
        })
        .state('main.category', {
          url: "/search/:category",
          views: {
            'content@': {
              templateUrl: 'static/app/components/news/category.html',
              controller: 'CategoryController',
              resolve: {
                category: function(NewsService, $stateParams) {
                  return NewsService.searchCategory($stateParams).then(function(data) {
                    return data;
                  })
                }
              }
            }
          }
        })
        .state('main.addNews', {
          url: "/news/create",
          views: {
            'content@': {
              templateUrl: 'static/app/components/news/newsForm.html',
              controller: 'NewsFormController',
              resolve: {
                news: function() {
                  return {}
                }
              }
            }
          }
        })
        .state('main.editNews', {
          url: "/news/edit/:id",
          views: {
            'content@': {
              templateUrl: 'static/app/components/news/newsForm.html',
              controller: 'NewsFormController',
              resolve: {
                news: function($stateParams, NewsService) {
                  return NewsService.getById($stateParams.id).then(function(data) {
                    return data;
                  })
                }
              }
            }
          }
        })
        .state('main.newsDetail', {
          url: "/news/:id",
          views: {
            'content@': {
              templateUrl: 'static/app/components/news/newsDetail.html',
              controller: 'NewsDetailController',
              resolve: {
                newsDetail: function($stateParams, NewsService) {
                  return NewsService.getById($stateParams.id).then(function(data) {
                    return data;
                  })
                }
              }
            }
          }
        })
    // .run(['$state', function($state) {
    //   $state.transitionTo('main.newsDetail');
    // }]);

  }
})();
