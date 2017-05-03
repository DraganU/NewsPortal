(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .controller('NewsDetailController', NewsDetailController);

  NewsDetailController.$inject = ["$scope", "news", "NewsService", "$state"];
  function NewsDetailController($scope, news, NewsService, $state) {

    $scope.news = news;

    $scope.submitNews = function() {    //saveEditNews RADI I EDIT I ADD new NEWS
      NewsService.saveEditNews($scope.news).then(onSuccess());     //$state.go("main.news")
      $state.go("main.news")
    }

    var onSuccess = function() {
      NewsService.getAllnews();
    }


  }

})();
