providersApp.controller('ReporteCtrl', ['$scope', '$http', 'userService', function ($scope, $http, userService) {
	
	$scope.reporte = {
		tipo: "",
		fechaInical: "",
		fechaFinal: "",
		listaServicios:[
		],
		listaPaquetes:[
		]
	};

	$scope.tipos=[];
	$scope.servicios=[];
	$scope.paquetes=[];
	$scope.filtro;
	$scope.idCategoria;
	$scope.content;
	$scope.$watch("ajaxURL", function (newValue, oldValue) {
//		$scope.filtro = "";
//		$scope.idCategoria = "";
		console.log("actualizando..." + $scope.idCategoria + "..." + $scope.filtro) 
		$http.get('/viagging-providers-web/getReportTypes').
		success(function(data, status, headers, config) {
			$scope.tipos = data;
		}).
		error(function(data, status, headers, config) {
		});
		$http.get('/viagging-providers-web/getServicesByProveedor',{
	        params: { 
	        	idCategory: $scope.idCategoria,
	        	idProveedor :  $scope.userData.id
	        	}
	    }).success(function(data, status, headers, config) {
	        $scope.servicios = data;
	    }).
	    error(function(data, status, headers, config) {
	    	 $scope.servicios = [];
	    }); 
		$http.get('/viagging-providers-web/getPackages',{
			params: { filtro: $scope.filtro, idUsuario : $scope.userData.id }
	    }).success(function(data, status, headers, config) {
	      $scope.paquetes = data;
	    }).
	    error(function(data, status, headers, config) {
	    	$scope.paquetes = [];
	    }); 
	});
	
//	$scope.generarReporte = function() {
//		console.log("Generando reporte" + angular.toJson($scope.reporte));
//	};
	
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
	
	$scope.generarReporte = function(reporte) {
		console.log($scope.reporte);
		$http.post('/viagging-api-report/createReport', $scope.reporte)
		   .success(function(data, status, headers, config) {
			   window.open("data:application/pdf;base64, " + data);
		}).error(function(data, status, headers, config) {
			alert("El reporte no pudo ser generado");
		}); 
	} 
}]);