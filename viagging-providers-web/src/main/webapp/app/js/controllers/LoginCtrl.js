providersApp.controller('LoginCtrl', ['$scope', '$rootScope', '$state', 'loginService',
    function($scope, $rootScope, $state, loginService){
	$rootScope.showReport = false;
	$rootScope.showMessage = false;
	$scope.userData = {
			id: "",
			login: "",
			password: "",
			correo: "",
			primerApellido: "",
			primerNombre: "",
	}
	
	'use strict';
	
	$scope.userLogin = {
		login: "",
		password: "",
		profile:"Proveedor"
	};
	
	var successCallback = function(map){
		$scope.userData = map["usuario"];
		alert("Bienvenido de nuevo " + $scope.userData.name + " " + $scope.userData.lastName);
		//console.log(map["derivadorReportes"]);
		//console.log(map["derivadorMensajes"]);
		//$rootScope.showReport = map["derivadorReportes"];
		//$rootScope.showMessage = map["derivadorMensajes"];
		$rootScope.$broadcast('USER_LOGGED_IN', $scope.userData);
        $rootScope.$broadcast('USER_LOGGED_IN', "$scope.userData");
		$state.go("alimentacion");
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