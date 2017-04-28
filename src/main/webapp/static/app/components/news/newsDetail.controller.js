(function(){

    'use strict';

    angular
        .module('news-portal.news')
        .controller('NewsDetailController',NewsDetailController);

    NewsDetailController.$inject = ["$scope","newNews","NewsService","$state"];
    function NewsDetailController ($scope,newNews,NewsService,$state){

       $scope.newNews = newNews;

       $scope.createNews = function () {
           NewsService.addNews($scope.newNews).then($state.go("main.news"));
       }
        //ako uradim sa push u niz news mozda necu morati refresovati stranicu
    }

})();