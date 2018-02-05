providersApp.controller('TransporteCtrl', ['$scope', 'userService', 'FileUploader', '$http', function($scope, userService, FileUploader, $http) {

	$scope.transporte = {
			servicio:{ 
				id: 0,
				nombre: "",
				descripcionCorta: "",
				activo: true,
				restricciones: "",
				caracteristicas: "",
				precio: "",
				fechaInicio: "",
				fechaFin: "",
				capacidad: "",
				usuario: {
					id: ""
				}
			},
			tipoTransporte: "",
			lugarOrigen: "",
			lugarDestino: "",
			tiempoEstimado: "",
			horarioInicio: "",
			horarioFin: ""
	}

	$scope.caracteristicas = [];
	$scope.transportTypes = [];
	$scope.selection = {};

	$scope.$watch("ajaxURL", function (newValue, oldValue) {
		$http.get('/viagging-providers-web/getFeatures?categoria=TRANSPORTE').
		success(function(data, status, headers, config) {
			$scope.caracteristicas = data;
		}).
		error(function(data, status, headers, config) {
		});
		$http.get('/viagging-providers-web/getTransportTypes').
		success(function(data, status, headers, config) {
			$scope.transportTypes = data;
		}).
		error(function(data, status, headers, config) {
		});
	});

	$scope.guardarTransporte = function(ftransporte) {
		var idService;
		var caracteristicas = [];
		for(valorCaracteristica in $scope.selection){
			var caracteristica = {
				valor: valorCaracteristica
			};
			caracteristicas.push(caracteristica);
		}
		$scope.transporte.servicio.caracteristicas = caracteristicas;
		$scope.transporte.servicio.usuario.id=$scope.userData.id;
		console.log($scope.transporte.servicio.caracteristicas);
		$http.post('/viagging-providers-web/saveTransport', angular.toJson($scope.transporte), {
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
		$scope.transporte = {
				servicio:{ 
					id: 0,
					nombre: "",
					descripcionCorta: "",
					activo: true,
					restricciones: "",
					caracteristicas: ""
				},
				tipoTransporte: "",
				lugarOrigen: "",
				lugarDestino: "",
				valor: "",
				tiempoEstimado: "",
				horarioInicio: "",
				horarioFin: "",
				frecuenciaSalida: "",
				numeroPasajeros: 2,
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

	// FILTERS

	uploader.filters.push({
		name: 'customFilter',
		fn: function(item /*{File|FileLikeObject}*/, options) {
			return this.queue.length < 10;
		}
	});

	console.info('uploader', uploader);
	
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