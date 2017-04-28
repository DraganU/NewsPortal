(function(){

	'use strict';

	angular
		.module('news-portal.news')
		.controller('NewsController',NewsController);

		NewsController.$inject = ["$scope", "news","$state","NewsService"];
		function NewsController ($scope,news,$state,NewsService){

			$scope.news = news;

            $scope.addNews = function () {
                $state.go("main.addNews");
            };
            
            $scope.removeNews = function (vest) {   //ako hocu da mi se prikazuje u url pormena putanje, koristicu router
                NewsService.deleteNews(vest);

            }

		}

})();