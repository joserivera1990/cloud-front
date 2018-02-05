providersApp.controller('AppCtrl', ['$scope', '$rootScope', 'userService',
    function($scope, $rootScope, userService){

	$scope.userData = userService.getUserData();
	$scope.isUserLoggedIn = $scope.userData != null;
	
	$rootScope.$on('USER_LOGGED_IN', function(event, userData){
		$scope.isUserLoggedIn = true;
		$scope.userData = userData;
	});
	
}]);
