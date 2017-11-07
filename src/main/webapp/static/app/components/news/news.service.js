(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .factory('NewsService', NewsService);

  NewsService.$inject = ['$http'];

  function NewsService($http) {

    var url = "http://108.61.211.179:8080/news-portal";

    var getAllnews = function() {
      return $http.get(url + "/news").then(function(response) {
        return response.data;
      });
    };

    var getById = function(id) {
      return $http.get(url + "/news/" + id).then(function(response) {
        return response.data;
      });
    };

    var createNewsAndEditNews = function(oneNews) {  //return $http.post(url + "/create", oneNews);
      return $http.post(url + "/news/create", oneNews).then(function(response) {
        return response.data;
      });
    };

    var deleteNews = function(vest) {
      return $http.delete(url + "/news/remove/" + vest.id);
    };

    var searchByCategory = function(params) {
      return $http.get(url + "/search/category?category=" + params).then(function(response) {
        console.log(response.data);
        return response.data;
      });
    };

    var searchByStatus = function(params) {
      return $http.get(url + "/search/status?status=" + params).then(function(response) {
        console.log(response.data);
        return response.data;
      });
    };

    var searchByTitle = function(params) {
      return $http.get(url + "/search/title?title=" + params).then(function(response) {
        console.log(response.data);
        return response.data;
      });
    };

    var stateReload = function(state) {
      state.reload();
    };

    return {
      getAllnews: getAllnews,
      createNewsAndEditNews: createNewsAndEditNews,
      deleteNews: deleteNews,
      getById: getById,
      searchByCategory: searchByCategory,
      searchByStatus: searchByStatus,
      searchByTitle: searchByTitle,
      stateReload: stateReload
    };
  }


})();
