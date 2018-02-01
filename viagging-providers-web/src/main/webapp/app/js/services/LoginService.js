providersApp.service('loginService', ['$http', '$q', 'userService', function($http, $q, userService){
	
	'use strict';
	
	var loginService = {
	
		loginUser : function(userLogin, successCallback, errorCallback){

			return $http({
	            url: "http://localhost:8090/api/user/login",
	            method: "POST",
	            data: userLogin,
	            cache: false
	        }).success(function(response){
	        	if(angular.isObject(response)){
                    console.log(response);
	        		userService.setUserData(response);

	        		successCallback(response);
	        	} else {
	        		errorCallback(response);
	        	}
	        	 
	        }).error(errorCallback);
		},
		
		logoutUser : function(){
			userService.removeUserData();
		},
		
		registerUser : function(user, successCallback, errorCallback){
			
			return $http({
	            url: "/viagging-api/register",
	            method: "POST",
	            data: user,
	            cache: false
	        }).success(function(response){
	        	if(angular.isObject(response)){
	        		userService.setUserData(response);
	        		successCallback(response);
	        	} else {
	        		errorCallback(response);
	        	}
	        	 
	        }).error(errorCallback);
		}
	
	};
	
	return loginService;
}]);