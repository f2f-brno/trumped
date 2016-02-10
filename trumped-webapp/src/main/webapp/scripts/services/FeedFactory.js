angular.module('trumpedwebapp').factory('FeedResource', function($resource){
    var resource = $resource('rest/feeds/:FeedId',{FeedId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});