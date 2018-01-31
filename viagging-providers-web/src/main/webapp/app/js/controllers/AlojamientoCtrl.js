providersApp.controller('AlojamientoCtrl', ['$scope', 'userService', 'FileUploader', '$http', function($scope, userService, FileUploader, $http) {

	$scope.alojamiento = {
			servicio:{ 
				id: 0,
				nombre: "",
				descripcionCorta: "",
				activo: true,
				restricciones: "",
				caracteristicas: "",
				precio: "",
				fechaInicial: "",
				fechaFinal: "",
				capacidad: "",
				usuario: {
					id: ""
				}
			},	
			ciudad: "",
			tipo: "",
			numeroPersonas: ""
	}

	$scope.caracteristicas = [];
	$scope.selection = {};

	$scope.$watch("ajaxURL", function (newValue, oldValue) {
		$http.get('/viagging-providers-web/getFeatures?categoria=ALOJAMIENTO').
		success(function(data, status, headers, config) {
			$scope.caracteristicas = data;
			console.log("caracteristicas" + data);
		}).
		error(function(data, status, headers, config) {
		});
	});

	$scope.guardarAlojamiento = function(falojamiento) {
		var idService;
		
		var caracteristicas = [];
		for(valorCaracteristica in $scope.selection){
			var caracteristica = {
				valor: valorCaracteristica
			};
			caracteristicas.push(caracteristica);
		}
		$scope.alojamiento.servicio.caracteristicas = caracteristicas;
		$scope.alojamiento.servicio.usuario.id=$scope.userData.id;
		console.log($scope.alojamiento);
		$http.post('/viagging-providers-web/saveLodging', angular.toJson($scope.alojamiento), {
			headers: {"Content-Type": "application/json"},
			transformRequest: angular.identity
		}).success(function(data, status, headers, config) {
			idService = data;
			for (var i = 0; i < uploader.queue.length; i++) {
				$http.put('/viagging-providers-web/saveImage', uploader.queue[i]._file, {
					params: { idServicio : idService },
	    			headers: {"Content-Type": "application/json"},
	    			transformRequest: angular.identity}
	    		)
	    		.success(function(response) {
	    			console.log('success', response);
	    		})
	    		.error(function(response) {
	    			console.log('error', response);
	    		});
			}
			reset();
			alert("El servicio fue creado!");
		}).error(function(data, status, headers, config) {
			alert("Error en la creación");
		}); 
	} 
	
	function reset() {
		$scope.alojamiento = {
				servicio:{ 
					id: 0,
					nombre: "",
					descripcionCorta: "",
					activo: true,
					restricciones: "",
					caracteristicas: "",
					precio: ""
				},	
				ciudad: ""
		};
		$scope.selection = {};
		uploader.queue = [];
	}
	
	$scope.cancel = function () {
		reset();
	}
	
	var uploader = $scope.uploader = new FileUploader({
		url: '/viagging-providers-web/guardarImagen'
	});
	
	$scope.statusInitial
	
	$scope.statusInitial={opened:false};
	$scope.statusFinal={opened:false};
	
	$scope.today = function() {
		$scope.dtMin = new Date();
		$scope.dtMax = new Date();
	};
	$scope.today();

	$scope.clear = function () {
		$scope.dtMin = null;
		$scope.dtMax = null;
	};

	// Disable weekend selection
	$scope.disabled = function(date, mode) {
		return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
	};

//	$scope.toggleMin = function() {
//		$scope.minDate = $scope.minDate ? null : new Date();
//	};
//	$scope.toggleMin();
	$scope.maxDate = new Date(2020, 5, 22);
	$scope.minDate = new Date(2000, 1, 1);

	$scope.openInitial = function($event) {
		$scope.statusInitial.opened = true;
	};
	
	$scope.openFinal = function($event) {
		$scope.statusFinal.opened = true;
	};

	$scope.setDate = function(year, month, day) {
		$scope.dt = new Date(year, month, day);
	};

	$scope.dateOptions = {
			formatYear: 'yy',
			startingDay: 1
	};

	$scope.status = {
			opened: false
	};

	var tomorrow = new Date();
	tomorrow.setDate(tomorrow.getDate() + 1);
	var afterTomorrow = new Date();
	afterTomorrow.setDate(tomorrow.getDate() + 2);
	$scope.events =
		[
		 {
			 date: tomorrow,
			 status: 'full'
		 },
		 {
			 date: afterTomorrow,
			 status: 'partially'
		 }
		 ];

	$scope.getDayClass = function(date, mode) {
		if (mode === 'day') {
			var dayToCheck = new Date(date).setHours(0,0,0,0);

			for (var i=0;i<$scope.events.length;i++){
				var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

				if (dayToCheck === currentDay) {
					return $scope.events[i].status;
				}
			}
		}

		return '';
	};
}]);