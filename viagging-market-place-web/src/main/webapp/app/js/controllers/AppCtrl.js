marketPlaceApp.controller('AppCtrl', ['$scope', '$rootScope', '$state', 'ngCart', 'userService',
    function($scope, $rootScope, $state, ngCart, userService){

	$scope.userData = userService.getUserData();
	$scope.isUserLoggedIn = $scope.userData != null;
	
	$rootScope.$on('USER_LOGGED_IN', function(event, userData){
		$scope.isUserLoggedIn = true;
		$scope.userData = userData;
	});
	
	$rootScope.$on('USER_UPDATED', function(event, userData){
		$scope.userData = userData;
	});
	
	 $scope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams){
    	    	
    	switch(toState.name){
	        case "checkout":
	        	if($scope.userData == null){
	        		event.preventDefault();
	    			alert("Debes estar logueado para proceder con la compra");
	    			$state.go("login");
	    		} else if($scope.userData.direccion1 == null){
	    			event.preventDefault();
	    			alert("Debes completar tus datos de facturación para proceder con el pago");
	    			$state.go("profile");
	    		}
        	break;
    	}
	 });
	
}]);