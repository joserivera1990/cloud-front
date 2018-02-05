providersApp.controller('AlimentacionCtrl', ['$scope', 'userService', 'FileUploader', '$http', function($scope, userService, FileUploader, $http) {

	$scope.alimentacion = {
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
			ciudad: "",
			horarioApertura: "",
			horarioCierre: "",
			precioMenor: "",
			precioMayor: "",
	}

	$scope.caracteristicas = [];
	$scope.selection = {};

	$scope.$watch("ajaxURL", function (newValue, oldValue) {
		$http.get('/viagging-providers-web/getFeatures?categoria=ALIMENTACION').
		success(function(data, status, headers, config) {
			$scope.caracteristicas = data;
			console.log("caracteristicas" + data);
		}).
		error(function(data, status, headers, config) {
		});
	});

	$scope.guardarAlimentacion = function(falimentacion) {
		var idService;
		var caracteristicas = [];
		for(valorCaracteristica in $scope.selection){
			var caracteristica = {
				valor: valorCaracteristica
			};
			caracteristicas.push(caracteristica);
		}
		$scope.alimentacion.servicio.caracteristicas = caracteristicas;
		$scope.alimentacion.servicio.usuario.id=$scope.userData.id;
		$http.post('/viagging-providers-web/saveFood', angular.toJson($scope.alimentacion), {
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
		$scope.alimentacion = {
				servicio:{ 
					id: 0,
					nombre: "",
					descripcionCorta: "",
					activo: true,
					restricciones: "",
					caracteristicas: "",
					precio: ""	
				},	
				ciudad: "",
				horarioApertura: "",
				horarioCierre: "",
				precioMenor: "",
				precioMayor: "",
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