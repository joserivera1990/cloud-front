marketPlaceApp.controller('OrderResponseCtrl', ['$scope', 'order', 'configService', function($scope, order, configService){

	initOrderResponseCtrl = function(){
		$scope.order = order;
		$scope.productUrl = "http://www.viagging.com/viagging-market-place-web/app/#/detail/" + order.compras[0].producto.id;
		$scope.variability = configService.getVariability();
	}();
	
}]);