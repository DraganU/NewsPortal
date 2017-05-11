(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .controller('NewsController', NewsController);

  NewsController.$inject = ["$scope", "news", "$state", "NewsService", "$stateParams"];
  function NewsController($scope, news, $state, NewsService, $stateParams) {

    $scope.news = news;
    $scope.hideFooter = false;

    $scope.addNews = function() {
      $state.go("main.addNews");
    };

    $scope.removeNews = function(vest) {
      NewsService.deleteNews(vest).then(states()).then($state.reload());
    }
    var states = function() {
      $state.go("main.news", { reload: true });
    }

  }

})();


// $scope.filter = {
//   search: $scope.search
// }
//
// $scope.$watch("filter", function() {
//   getNewsByCategory();
// }, true);
//
// var getNewsByCategory = function() {
//   NewsService.getAllnews({
//     "filter": {
//       "search": $scope.filter.search
//     }
//   }).then(function(data) {
//     $scope.news = data;
//   });
// };
// getNewsByCategory();
