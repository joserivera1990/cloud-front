marketPlaceApp.controller('ProductsCtrl', ['$scope', 'filterFilter', function($scope, filterFilter){

	//Pagination controls
	$scope.currentPage = 1;
	$scope.totalItems = $scope.products.length;
	$scope.entryLimit = 6;
	$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

}]);