(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .controller('NewsDetailController', NewsDetailController);

  NewsDetailController.$inject = ["$scope", "newNews", "NewsService", "$state"];
  function NewsDetailController($scope, newNews, NewsService, $state) {

    $scope.newNews = newNews;

    $scope.createNews = function() {
      NewsService.addNews($scope.newNews).then(onSuccess());     //$state.go("main.news")
      $state.go("main.news")
    }

    var onSuccess = function() {
      NewsService.getAllnews();
    }

  }

})();
