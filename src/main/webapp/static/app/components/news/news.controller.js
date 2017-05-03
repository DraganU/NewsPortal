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
      NewsService.deleteNews(vest).then(onSuccess());    //$state.reload()
      $state.reload();
    }

    var onSuccess = function() {
      NewsService.getAllnews();
    }

    $scope.editNews = function(vest) {
      $state.go("main.editNews", { vest: vest });
    }

  }

})();


// CTRL ALT L    TI JE FORMATIRANJE KODA, NAMESTIO SAM TI FORMATERE DA SE UCIS DA PISES UREDAN KOD.
// OVDE SAM TI UBACIO .RELOAD() DA OSVEZI STRANICU POSLE BRISANJA.
