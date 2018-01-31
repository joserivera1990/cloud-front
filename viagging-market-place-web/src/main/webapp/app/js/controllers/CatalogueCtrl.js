marketPlaceApp.controller('CatalogueCtrl', ['$scope', '$state', 'configService', 'products', 'userService',
    function($scope, $state, configService, products, userService){

	$scope.products = products;
	
	$scope.busqueda = null;

}]);