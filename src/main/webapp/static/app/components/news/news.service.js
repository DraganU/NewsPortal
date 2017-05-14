(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .factory('NewsService', NewsService);

  NewsService.$inject = ['$http'];
  function NewsService($http) {

    var url = "http://localhost:8091/news";

    var getAllnews = function() {
      return $http.get(url).then(function(response) {
        return response.data;
      });
    };

    var createNewsAndEditNews = function(oneNews) {  //return $http.post(url + "/create", oneNews);
      return $http.post(url + "/create", oneNews).then(function(response) {
        return response.data;
      });
    };

    var getById = function(id) {
      return $http.get(url + "/" + id).then(function(response) {
        return response.data;
      });
    }

    var deleteNews = function(vest) {
      return $http.delete(url + "/remove/" + vest.id);
    };

    var searchCategory = function(params) {
      return $http.get("http://localhost:8091/search/category?category=" + params).then(function(response) {
        console.log(response.data);
        return response.data;
      });
    }

    return {
      getAllnews: getAllnews,
      createNewsAndEditNews: createNewsAndEditNews,
      deleteNews: deleteNews,
      getById: getById,
      searchCategory: searchCategory
    };

  }

})();
