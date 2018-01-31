providersApp.controller('UsuarioCtrl', ['$scope', 'FileUploader', '$http', 'userService', function($scope, FileUploader, $http, userService) {

	$scope.listUsers = {
			perfil:{ 
				id: 0,
				nombre: "ADMIN"
			},	
			primerNombre: "",
			primerApellido: ""
	}

	$scope.usuario = {
			id: 0,
			login: "",
			password: "",
			correo: "",
			numeroCelular: "",
			numeroDocumento: "",
			primerApellido: "",
			primerNombre: "",
			segundoApellido: "",
			segundoNombre: "",
			tipoDocumento: "",
			direccion1: "",
			direccion2: "",
			ciudad: "",
			pais: ""
	};
	
	$scope.getUser = function() {    
		$http.get('/viagging-providers-web/getUser', {params: { userId : $scope.userData.id }}).
		success(function(data, status, headers, config) {
			console.log("consulto bien");
			$scope.usuario = data;
			console.log(data);
		}).
		error(function(data, status, headers, config) {
			// log error
		}); 

		$http.get('/viagging-providers-web/getTypeDocuments').
		success(function(data, status, headers, config) {
			$scope.tipoDocumento = data;
		}).
		error(function(data, status, headers, config) {
			// log error
		}); 
	}

	$scope.updateProvider = function() { 
		console.log($scope.usuario);
		$http.post('/viagging-providers-web/updateProvider',$scope.usuario).
		success(function(data, status, headers, config) {
			console.log(status);
			alert("Transacción Exitosa");
		}).
		error(function(data, status, headers, config) {
			console.log(data);
			alert(data.message);
		}); 
	}

	function reset() {
		$scope.usuario = {
				id: 0,
				login: "",
				password: "",
				correo: "",
				numeroCelular: "",
				numeroDocumento: "",
				primerApellido: "",
				primerNombre: "",
				segundoApellido: "",
				segundoNombre: "",
				tipoDocumento: "",
				direccion1: "",
				direccion2: "",
				ciudad: "",
				pais: ""
		};
	}

	$scope.cancel = function () {
		reset();
	}



}]);