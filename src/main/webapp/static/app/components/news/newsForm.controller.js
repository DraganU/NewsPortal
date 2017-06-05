(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .controller('NewsFormController', NewsFormController);

  NewsFormController.$inject = ["$scope", "news", "NewsService", "$state", "$timeout"];
  function NewsFormController($scope, news, NewsService, $state, $timeout) {

    $scope.news = news;
    $scope.status = ["BREAKING", "MOSTPOPULAR", "STANDARD"];
    $scope.category = ["POLITIKA", "EKONOMIJA", "KULTURA", "ZABAVA", "SPORT"];

    $scope.submitNews = function() {    // createNewsAndEditNews RADI I EDIT I ADD new NEWS
      NewsService.createNewsAndEditNews($scope.news).then($timeout(function() {
            $state.go('main.news');   //  OVDE RADI STATE.GO JER MENJAMO STANJE, VRACAMO SE NA DRUGI STATE
            //stateRefresh();        // ovo radi
            //state.reload('main.news');   //ovako ce reloadoovati al i nece prebaciti na news stranicu
          }, 100)
      )
    }

    var stateRefresh = function() {
      $state.go('main.news',
          {
            location: true, inherit: false, relative: 'main.news', notify: true, reload: true
          });
    }


  }
})();
