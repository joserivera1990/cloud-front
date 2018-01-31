marketPlaceApp.controller('SearchCtrl', ['$scope', '$state', 'configService', 'products', '$filter',
    function($scope, $state, configService, products, $filter){
	
	//Pagination controls
	$scope.entryLimit = 6;
	
	//Filter products
	$scope.filterProducts = function(){
		$scope.filteredProducts = $filter('productsFilter')($scope.products, $scope.busqueda, $scope.selectedCategories);
		$scope.currentPage = 1;
		$scope.totalItems = $scope.filteredProducts.length;
		$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);
	};
	
	$scope.$on("event_SEARCH", function(event, busqueda){
		$scope.busqueda = busqueda;
		$scope.filterProducts($scope.products, $scope.busqueda, $scope.selectedCategories);
	});

	$scope.selectedCategories = [];
	$scope.seleccionarCategoria = function(categoria){
		var categoryIndex = $scope.selectedCategories.indexOf(categoria);
		if(categoryIndex > -1){
			$scope.selectedCategories.splice(categoryIndex, 1);
		} else {
			$scope.selectedCategories.push(categoria);
		}
		
		$scope.filterProducts($scope.products, $scope.busqueda, $scope.selectedCategories);
	};
	
	$scope.categories = configService.getCategories();
	$scope.prices = configService.getPrices();

	$scope.products = products;
	$scope.filteredProducts = products;
	
	$scope.busqueda = angular.copy($state.params.busqueda);
	
	//ProductsCtrl
	if($scope.busqueda && $scope.busqueda != ""){
		$scope.filterProducts($scope.products, $scope.busqueda.texto, $scope.selectedCategories);
	} else {
		$scope.currentPage = 1;
		$scope.totalItems = $scope.filteredProducts.length;
		$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);
	}
}]);