marketPlaceApp.directive('marketPlaceLoading', ['$http', '$timeout', function ($http, $timeout){
    return {
        restrict: 'A',
        templateUrl: 'views/loading.html',
        link: function (scope,  element, attrs){
            scope.isLoading = function(){
            	return $http.pendingRequests.length > 0;
            };
            
            scope.$watch(scope.isLoading, function (v) {
                if(v){
                	$(element).fadeIn();
                }else {
                	$(element).fadeOut();
                }
            });
        }        	
    };
}]);