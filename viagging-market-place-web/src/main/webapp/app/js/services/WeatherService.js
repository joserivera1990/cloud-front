marketPlaceApp.service('weatherService', ['$http', '$q', 'productsService', 'configService', function($http, $q, productsService, configService){
	
	var weatherService = {
		
		getWeather : function(){
			var ciudad = productsService.getCurrentProduct().servicios[0].ciudad;
			var hasWeather = configService.getVariability().hasWeather;
			
			if(!hasWeather){
				return $q.resolve(null);
			}else{
				return $http({
		            url: "/viagging-api-weather/weather/" + ciudad,
		            method: "GET",
		            cache: false
		        }).then(function successCallback(response) {
		        	if(angular.isObject(response.data)){
		        		return $q.resolve(response.data);
		        	} else {
		        		return $q.resolve(null);
		        	}
		        }, function errorCallback(response) {
		        	return $q.resolve(null);
		        });
			}
		},
	};
	return weatherService;
}]);