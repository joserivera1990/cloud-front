providersApp.controller('MenuCtrl', ['$scope', '$location', '$state', 'loginService',
    function($scope, $location, $state, loginService){
	
	$scope.logoutUser = function(){
		loginService.logoutUser();
		$scope.isUserLoggedIn = false;
		$state.go("home");
	};
	
}]);