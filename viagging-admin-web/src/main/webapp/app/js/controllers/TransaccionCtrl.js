providersApp.controller('TransaccionCtrl', ['$scope', '$http', 'userService', function ($scope, $http, userService) {
	
	$scope.reporte = {
		tipo: "",
		fechaInical: "",
		fechaFinal: "",
		listaServicios:[
		                {"id":1}, 
			            {"id":2}, 
			            {"id":3}
		],
		listaPaquetes:[
			            {"id":325}
		]
	};

	$scope.tipos=[];
	$scope.servicios=[];
	$scope.paquetes=[];
	$scope.filtro;
	$scope.idCategoria;
	
	$scope.generarMonitoreo = function() {
		$http.get('/viagging-providers-web/getRendimiento',{
			params: { 
				fechaInicial: $scope.reporte.fechaInicial,
	        	fechaFinal :  $scope.reporte.fechaFinal
	        	}	
		}).success(function(data, status, headers, config) {
			console.log(status);
			$scope.listRendimiento = data;
			console.log(data);
		}).
		error(function(data, status, headers, config) {
			// log error
		}); 
		
	};
		
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