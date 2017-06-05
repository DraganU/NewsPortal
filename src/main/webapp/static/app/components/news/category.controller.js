(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .controller('CategoryController', CategoryController);

  CategoryController.$inject = ["$scope", "category", "$state", "NewsService", "$stateParams"];
  function CategoryController($scope, category, $state, NewsService, $stateParams) {

    $scope.category = category;

  }

})();
