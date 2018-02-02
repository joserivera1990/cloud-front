providersApp.controller('PreguntasCtrl', ['$scope', 'userService', '$http', '$rootScope', '$state', function($scope,userService, $http, $rootScope, $state) {

	$scope.question;
	$scope.id;
    $scope.ocultarSeccionActualizarPaquete = true;

	
	$scope.$watch("ajaxURL", function (newValue, oldValue) {
        userData = userService.getUserData();
        idUser = userData.idUser;
		$http.get('http://localhost:8090/api/events/user/'+idUser).
		success(function(data, status, headers, config) {
			$scope.events = data;
		}).
		error(function(data, status, headers, config) {
		});
	});

    $scope.getEvent = function(idEvento) {
        $http.get('http://localhost:8090/api/events/'+idEvento).
        success(function(data, status, headers, config) {
            $scope.event = data;
            console.log("here");
            console.log($scope.event);
            $scope.ocultarSeccionActualizarPaquete = false;
        }).
        error(function(data, status, headers, config) {
        });
    }
	
	$scope.responderPregunta = function(fpregunta) { 
		$http.post('/viagging-providers-web/answerQuestion', angular.toJson($rootScope.question), {
			headers: {"Content-Type": "application/json"},
			transformRequest: angular.identity
		}).success(function(data, status, headers, config) {
			alert("Se guardó la respuesta!");
			$state.go("pregunta");
		}).error(function(data, status, headers, config) {}); 
    }
	
}]);