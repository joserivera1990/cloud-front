marketPlaceApp.service('faqService', ['$http', '$q', function($http, $q){
	
	var faqs = [];
	
	var faqService = {
			
		getAllFaqs : function(){
			return $http({
	            url: "/viagging-api/faq",
	            method: "GET",
	            cache: false
	        }).then(function successCallback(response) {
	        	if(angular.isArray(response.data)){
	        		faqs = response.data;
	        		return $q.resolve(response.data);
	        	} else {
	        		return $q.reject(response.data);
	        	}
	        }, function errorCallback(response) {
	        	return $q.reject(response.data);
	        });
		},
		getFaqs : function(){
			return faqs;
		}
	};
	return faqService;
}]);