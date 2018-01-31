marketPlaceApp.service('paymentsService', [ '$http', function($http){
	
	'use strict';
	
	var paymentsService = {
		submitPayment : function(payment, successCallback, errorCallback){
			$http({
				url: "/viagging-api/payments/submit",
				method: "POST",
	            cache: false,
	            data: payment
	        }).success(successCallback).error(errorCallback);
		}
	};
	
	return paymentsService;
	
}]);