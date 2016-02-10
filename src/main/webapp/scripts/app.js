'use strict';

angular.module('trumpedwebapp',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Feeds',{templateUrl:'views/Feed/search.html',controller:'SearchFeedController'})
      .when('/Feeds/new',{templateUrl:'views/Feed/detail.html',controller:'NewFeedController'})
      .when('/Feeds/edit/:FeedId',{templateUrl:'views/Feed/detail.html',controller:'EditFeedController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
