marketPlaceApp.controller('OrdersCtrl', ['$scope', 'orders', function($scope, orders){

	initOrdersCtrl = function(){
		$scope.orders = orders;
	}();

}]);