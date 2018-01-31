marketPlaceApp.controller('ProfileCtrl', ['$scope', '$rootScope', 'userService',  function($scope, $rootScope, userService){

	$scope.userData = userService.getUserData();
	
	var successCallback = function(){
		$rootScope.$broadcast("USER_UPDATED", angular.copy($scope.userData));
		alert("Tus datos han sido actualizados exitosamente");
	};
	
	var errorCallback = function(){
		alert("Ha ocurrido un error al actualizar los datos");
	};
	
	$scope.updateUser = function(){
		userService.updateUser($scope.userData, successCallback, errorCallback);
	};
	
	$scope.updateUserAddress = function(){
		userService.updateUser($scope.userData, successCallback, errorCallback);
	};

}]);