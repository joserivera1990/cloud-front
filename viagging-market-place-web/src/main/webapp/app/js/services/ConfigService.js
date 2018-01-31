marketPlaceApp.service('configService', ['$http', '$q', 'storageService', function($http, $q, storageService){

	'use strict';

	var applicationConfig = {};

	var initApplicationConfig = function(config){
		applicationConfig.categories = config.categories;
		applicationConfig.prices = config.prices;
		applicationConfig.variability = config.variabilidad;
	};

	var configService = {

		initMarketPlaceConfig : function(){

			var marketPlaceConfig = storageService.get('marketPlaceConfig');
			if(marketPlaceConfig != null){
				initApplicationConfig(marketPlaceConfig);
				return $q.resolve(marketPlaceConfig);
			} else {
				return $http({
		            url: "/viagging-market-place-web/marketplace/config",
		            method: "GET",
		            cache: false
		        }).then(function successCallback(response) {
		        	if(angular.isObject(response.data)){
		        		var marketPlaceConfig = response.data;
		        		//Set application config data
		        		initApplicationConfig(marketPlaceConfig);
		        		//storageService.put('marketPlaceConfig', marketPlaceConfig);
		        		return $q.resolve(response.data);
		        	} else {
		        		return $q.reject(response.data);
		        	}
		        }, function errorCallback(response) {
		        	return $q.reject(response.data);
		        });
			}
		},

		getCategories : function(){
			return applicationConfig.categories;
		},

		getPrices : function(){
			return applicationConfig.prices;
		},

		getVariability : function(){
			return applicationConfig.variability;
		}
	};

	return configService;
}]);