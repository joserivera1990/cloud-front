marketPlaceApp.controller('OrderDetailCtrl', ['$scope', 'order', function($scope, order){

	initOrderDetailCtrl = function(){
		$scope.order = order;
	}();
	
}]);