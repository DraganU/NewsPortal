(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .controller('NewsController', NewsController);

  NewsController.$inject = ["$scope", "news", "$state", "NewsService", "$stateParams", "$timeout"];
  function NewsController($scope, news, $state, NewsService, $stateParams, $timeout) {

    $scope.news = news;

    $scope.searchTitleFunc = function() {
      NewsService.searchByTitle($scope.searchTitle).then(function(data) {
        $scope.news = data;
      })
    }


    $scope.addNews = function() {
      $state.go("main.addNews");
    }

    $scope.removeNews = function(vest) {
      NewsService.deleteNews(vest)
          .then($timeout(function() {
                $state.reload();  //dovoljno je samo ovo (umesto stateRefresh();) a sa pozivom $state.go('main.news') NECE RADIti
              }, 300)             //JER JE ON VEC NA NEWS STR. NE MOZE DA SE OPET PREKO 'main.news', vrati na samu sebe neg mora state.reload
          )
    }

    // var stateRefresh = function() {               //moze i da pise $state.go() umesto trransitionTo; isto je
    //   $state.go('main.news', $stateParams, {
    //     reload: true,
    //     inherit: false,
    //     notify: true
    //   });
    // }

  }

})
();



