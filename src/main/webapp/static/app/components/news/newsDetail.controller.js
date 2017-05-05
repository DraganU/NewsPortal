(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .controller('NewsDetailController', NewsDetailController);

  NewsDetailController.$inject = ["$scope", "newsDetail", "NewsService"];
  function NewsDetailController($scope, newsDetail, NewsService) {

    $scope.newsDetail = newsDetail;

  }

})();
