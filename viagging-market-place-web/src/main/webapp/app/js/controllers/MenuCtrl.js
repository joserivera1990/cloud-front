marketPlaceApp.controller('MenuCtrl', ['$scope', '$location', '$state', 'loginService', 'configService',
    function($scope, $location, $state, loginService, configService){

	$scope.logoutUser = function(){
		loginService.logoutUser();
		$scope.isUserLoggedIn = false;
		$state.go("home");
	};

	initMenuCtrl = function(){
		$scope.variability = configService.getVariability();
	}();

}]);