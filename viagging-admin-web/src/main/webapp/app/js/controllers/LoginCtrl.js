providersApp.controller('LoginCtrl', ['$scope', '$rootScope', '$state', 'loginService',
    function($scope, $rootScope, $state, loginService){
	
	'use strict';
	$scope.userData = {
			id: "",
			login: "",
			password: "",
			correo: "",
			numeroCelular : "",
			numeroDocumento: "",
			primerApellido: "",
			primerNombre: "",
			segundoApellido: "",
			segundoNombre : "",
			tipoDocumento: "",
			direccion1: "",
			direccion2: "",
			ciudad: "",
			pais : "",
			estado: "",
			zipcode: ""
	}
	
	$scope.userLogin = {
		login: "",
		password: "",
		profile:"Administrador"
	};
	
	var successCallback = function(map){
		console.log(map["usuario"]);
		$scope.userData = map["usuario"];
		alert("Bienvenido de nuevo " + $scope.userData.primerNombre + " " + $scope.userData.primerApellido);
		$rootScope.$broadcast('USER_LOGGED_IN', $scope.userData);	
		$state.go("crear");
	};
	
	var errorCallback = function(){
		alert("Las credenciales que ha ingresado no son validas!");
		$scope.userLogin.password = "";
	};
	
	$scope.loginUser = function(){
		loginService.loginUser($scope.userLogin, successCallback, errorCallback);
	};
}]);