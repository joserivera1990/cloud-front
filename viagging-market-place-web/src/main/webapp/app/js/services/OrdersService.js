marketPlaceApp.service('ordersService', ['$http', '$q', 'userService', function($http, $q, userService){
	
	var ordersService = {
		
		getOrdersByUsuarioId : function(){
			var userData = userService.getUserData();
			
			return $http({
				url: "/viagging-api/user/" + userData.id + "/orders/",
				method: "GET",
	            cache: false
	        }).then(function successCallback(response) {
	        	if(angular.isArray(response.data)){
	        		return $q.resolve(response.data);
	        	} else {
	        		return $q.reject(response.data);
	        	}
	        }, function errorCallback(response) {
	        	return $q.reject(response.data);
	        });
		},
		
		getOrderById : function(orderId){
			var userData = userService.getUserData();
			return $http({
				url: "/viagging-api/user/" + userData.id + "/orders/" + orderId,
				method: "GET",
	            cache: false
	        }).then(function successCallback(response) {
	        	if(angular.isObject(response.data)){
	        		return $q.resolve(response.data);
	        	} else {
	        		return $q.reject(response.data);
	        	}
	        }, function errorCallback(response) {
	        	return $q.reject(response.data);
	        });
		}
	};
	
	return ordersService;
}]);
