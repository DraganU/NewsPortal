(function() {

  'use strict';

  angular
      .module('news-portal.news')
      .factory('NewsService', NewsService);

  NewsService.$inject = ['$http'];
  function NewsService($http) {

    var url = "http://localhost:8091/news";

    var getAllnews = function(params) {
      return $http.get(url, { "params": params }).then(function(response) {  //mozda zatreba params za search i filter
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

    return {
      getAllnews: getAllnews,
      createNewsAndEditNews: createNewsAndEditNews,
      deleteNews: deleteNews,
      getById: getById
    };

  }

})();
