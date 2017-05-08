(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .controller('NewsController', NewsController);

  NewsController.$inject = ["$scope", "news", "$state", "NewsService", "$stateParams"];
  function NewsController($scope, news, $state, NewsService, $stateParams) {

    $scope.news = news;

    $scope.filter = {
      category: $stateParams.category ? $stateParams.category : ''
      //search: $scope.search
    }

    $scope.$watch("filter", function() {
      getNewsByCategory();
    }, true);

    var getNewsByCategory = function() {
      NewsService.getAllnews({
        "filter": {
          "category": $scope.filter.category
        }
      }).then(function(data) {
        $scope.news = data;
      });
    };
    getNewsByCategory();

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



