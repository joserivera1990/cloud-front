marketPlaceApp.service('wishListService', ['$http', '$q', function($http, $q){
	
	var wishListService = {
			
		getAllWishList : function(){
			return $http({
	            url: "/viagging-api/wishList",
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
		
		addWishToList : function(listaDeseo){
			return $http({
	            url: "/viagging-api/wishList",
	            method: "POST",
	            cache: false,
	            data: listaDeseo
	        }).then(function successCallback(response) {
        		return $q.resolve(response);
	        }, function errorCallback(response) {
	        	return $q.reject(response);
	        });
		}
	};
	return wishListService;
}]);