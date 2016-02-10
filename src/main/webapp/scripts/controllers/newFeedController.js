
angular.module('trumpedwebapp').controller('NewFeedController', function ($scope, $location, locationParser, flash, FeedResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.feed = $scope.feed || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The feed was created successfully.'});
            $location.path('/Feeds');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        FeedResource.save($scope.feed, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Feeds");
    };
});