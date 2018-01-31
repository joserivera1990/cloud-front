marketPlaceApp.controller('RegisterCtrl', ['$scope', '$rootScope', '$state', 'loginService', 'emailValidationHelper', 'configService',
   function($scope, $rootScope, $state, loginService, emailValidationHelper, configService){

	$scope.user = {
		primerNombre: "",
		primerApellido: "",
		correo: "",
		login: "",
		password: "",
		passwordCopy: "",
	};

	$scope.userLogin = {
		login: "",
		password: "",
	};

	var registerSuccessCallback = function(userData){
		alert("Bienvenido a Viagging " + userData.primerNombre + " " + userData.primerApellido);
		$rootScope.$broadcast('USER_LOGGED_IN', userData);
		$state.go("home");
	};

	var registerErrorCallback = function(){
		alert("Ha ocurrido un error durante el registro.");
		$scope.user.password = "";
		$scope.user.passwordCopy = "";
	};

	var loginSuccessCallback = function(userData){
		alert("Bienvenido de nuevo " + userData.primerNombre + " " + userData.primerApellido);
		$rootScope.$broadcast('USER_LOGGED_IN', userData);
		$state.go("home");
	};

	var loginErrorCallback = function(){
		alert("Las credenciales que ha ingresado no son válidas!");
		$scope.user.password = "";
	};

	var validateForm = function(){
		var validForm = true;
		if($scope.user.password !== $scope.user.passwordCopy){
			validForm = false;
			alert("La contraseña no coincide");
		} else if(!emailValidationHelper.validateEmail($scope.user.correo)){
			validForm = false;
			alert("El correo no es válido");
		}
		return validForm;
	};

	$scope.registerUser = function(){
		if(validateForm()){
			loginService.registerUser($scope.user, registerSuccessCallback, registerErrorCallback);
		}
	};

	$scope.loginUser = function(){
		loginService.loginUser($scope.userLogin, loginSuccessCallback, loginErrorCallback);
	};

	$scope.loginTwitterUser = function(){
		loginService.loginTwitterUser();
	};

	$scope.loginFacebookUser = function(){
		loginService.loginFacebookUser();
	};
	
	$scope.$on("USER_LOGGED_IN_BY_SOCIAL_NETWORK", function(event, userData){
		loginSuccessCallback(userData);
	});
	
	$scope.$on("USER_REGISTERED_IN_BY_SOCIAL_NETWORK", function(event, userData){
		registerSuccessCallback(userData);
	});
	
	$scope.$on("ERROR_REGISTERING_SOCIAL_NETWORK_USER", function(){
		registerErrorCallback();
	});

	$scope.initRegisterCtrl = function(){
		$scope.variability = configService.getVariability();
	}();

}]);