(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .controller('NewsController', NewsController);

  NewsController.$inject = ["$scope", "news", "$state", "NewsService"];
  function NewsController($scope, news, $state, NewsService) {

    $scope.news = news;

    $scope.addNews = function() {
      $state.go("main.addNews");
    };


    $scope.removeNews = function(vest) {
      NewsService.deleteNews(vest).then(onSuccess());    //$state.reload() - da osvezi stranicu posle brisanja
      $state.reload();
    }

    var onSuccess = function() {
      NewsService.getAllnews();
    }

  }

})();



