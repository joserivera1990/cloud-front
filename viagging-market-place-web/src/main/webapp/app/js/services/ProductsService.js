marketPlaceApp.service('productsService', ['$http', '$q', 'userService', function($http, $q, userService){

	var products = [];
	
	var currentProduct = {};
	
	var productsService = {

		getAllProducts : function(){
			if(products != null && products.length > 0){
				return $q.resolve(products);
			}

			return $http({
	            url: "/viagging-api/products",
	            method: "GET",
	            cache: false
	        }).then(function successCallback(response) {
	        	if(angular.isArray(response.data)){
	        		products = response.data;
	        		return $q.resolve(response.data);
	        	} else {
	        		return $q.reject(response.data);
	        	}
	        }, function errorCallback(response) {
	        	return $q.reject(response.data);
	        });
		},

		getProductById : function(productId){
			var headers = {};
			var userData = userService.getUserData();
			if(userData != null){
				headers.token = userData.jwtToken;
			}
			
			return $http({
				url: "/viagging-api/products/" + productId,
				method: "GET",
	            cache: false,
	            headers: headers
	        }).then(function successCallback(response) {
	        	if(angular.isObject(response.data)){
	        		currentProduct = response.data;
	        		return $q.resolve(response.data);
	        	} else {
	        		return $q.reject(response.data);
	        	}
	        }, function errorCallback(response) {
	        	return $q.reject(response.data);
	        });
		},

		findProducts : function(busqueda){
			var headers = {};
			var userData = userService.getUserData();
			if(userData != null){
				headers.token = userData.jwtToken;
			}
			
			if(busqueda == null){
				busqueda = { texto : "" };
			}

			return $http({
	            url: "/viagging-api/products/find",
	            method: "POST",
	            cache: false,
	            data: busqueda,
	            headers: headers
	        }).then(function successCallback(response) {
	        	if(angular.isArray(response.data)){
	        		products = response.data;
	        		return $q.resolve(response.data);
	        	} else {
	        		return $q.reject(response.data);
	        	}
	        }, function errorCallback(response) {
	        	return $q.reject(response.data);
	        });
		},

		addCommentToProduct : function(comment, productId, successCallback, errorCallback){
			$http({
				url: "/viagging-api/products/" + productId + "/comment",
				method: "POST",
	            cache: false,
	            data: comment
	        }).success(successCallback).error(errorCallback);
		},

		addQuestionToProduct : function(question, productId, successCallback, errorCallback){
			$http({
				url: "/viagging-api/products/" + productId + "/question",
				method: "POST",
	            cache: false,
	            data: question
	        }).success(successCallback).error(errorCallback);
		},
		
		getCurrentProduct: function(){
			return currentProduct;
		}
	};

	return productsService;
}]);