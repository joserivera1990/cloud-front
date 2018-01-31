providersApp.service('loginService', ['$http', 'userService', function($http, userService){
	
	'use strict';
	
	var loginService = {
	
		loginUser : function(userLogin, successCallback, errorCallback){
			
			return $http({
	            url: "/viagging-providers-web/loginProvAdmin",
	            method: "POST",
	            data: userLogin,
	            cache: false
	        }).success(function(response){
	        	console.log(response);
	        	if(angular.isObject(response)){
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