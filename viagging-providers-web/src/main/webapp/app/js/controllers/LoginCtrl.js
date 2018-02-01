providersApp.controller('LoginCtrl', ['$scope', '$rootScope', '$state', 'loginService',
    function($scope, $rootScope, $state, loginService){
	$rootScope.showReport = false;
	$rootScope.showMessage = false;
	$scope.userData = {
        idUser: "",
        name: "",
        lastName: "",
        email: "",
        password: "",
        registerDate: "",
	}
	
	'use strict';
	
	$scope.userLogin = {
        email: "text",
		password: "",
		profile:"Proveedor"
	};
	
	var successCallback = function(map){
		$scope.userData = map;
		alert("Bienvenido de nuevo " + $scope.userData.name + " " + $scope.userData.lastName);
		//$rootScope.showReport = map["derivadorReportes"];
		//$rootScope.showMessage = map["derivadorMensajes"];
		$rootScope.$broadcast('USER_LOGGED_IN', $scope.userData);
        $rootScope.$broadcast('USER_LOGGED_IN', "$scope.userData");
		$state.go("alojamiento");
	};
	
	var errorCallback = function(){
		alert("Las credenciales que ha ingresado no son válidas!");
		$scope.userLogin.password = "";
	};
	
	$scope.loginUser = function(){
		loginService.loginUser($scope.userLogin, successCallback, errorCallback);
	};
	
	$scope.isDisplayed=function(item, filter){
		console.log("ingreso a  -- ");
		    return true;
		}
}]);