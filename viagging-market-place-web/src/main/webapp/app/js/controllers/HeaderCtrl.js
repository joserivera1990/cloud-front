marketPlaceApp.controller('HeaderCtrl', ['$scope', '$rootScope', '$state', 'productsService',
    function($scope, $rootScope, $state, productsService){		

	$scope.busqueda = "";		
	
	var findProductsPost = function(){
		var busqueda = { texto: $scope.busqueda };
		productsService.findProducts(busqueda);
	};
	
	$scope.buscarProductos = function(){
		findProductsPost();
		if($state.current.name === "search"){
			$scope.$broadcast("event_SEARCH", $scope.busqueda);
		} else {
			$state.go("search", { busqueda: $scope.busqueda });
		}
	};
	
}]);