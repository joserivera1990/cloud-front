providersApp.controller('PreguntasCtrl', ['$scope', '$http', '$rootScope', '$state', function($scope, $http, $rootScope, $state) {

	$scope.question;
	$scope.id;
	
	$scope.$watch("ajaxURL", function (newValue, oldValue) {
		$http.get('/viagging-providers-web/getQuestions').
		success(function(data, status, headers, config) {
			console.log("caracteristicas" + data);
			$scope.questions = data;
		}).
		error(function(data, status, headers, config) {
		});
	});
	
	$scope.getPregunta = function(idPregunta) { 
		for (var i = 0; i < $scope.questions.length; i++) {
			if ($scope.questions[i].id == idPregunta) {
				$rootScope.question = $scope.questions[i];
				$scope.id = $scope.question.id;
			}
		}
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