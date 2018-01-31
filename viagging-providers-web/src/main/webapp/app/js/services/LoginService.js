providersApp.service('loginService', ['$http', '$q', 'userService', function($http, $q, userService){
	
	'use strict';
	
	var loginService = {
	
		loginUser : function(userLogin, successCallback, errorCallback){

            return $http({
                url: "http://localhost:8090/api/user/email/" + userLogin.login + "/password/"+userLogin.password,
                method: "GET",
                cache: false
            }).then(function successCallback(response) {
                if(angular.isArray(response.data)){
                    console.log(response);
                    console.log(response.data);
                    userService.setUserData(response);
                    successCallback(response);
                   // return $q.resolve(response.data);
                } else {
                    return $q.reject(response.data);
                }
            }, function errorCallback(response) {
                return $q.reject(response.data);
            });


		/*	return $http({
	            url: "/viagging-providers-web/loginProvAdmin",
	            method: "POST",
	            data: userLogin,
	            cache: false
	        }).success(function(response){
	        	if(angular.isObject(response)){
	        		userService.setUserData(response);
	        		successCallback(response);
	        	} else {
	        		errorCallback(response);
	        	}
	        	 
	        }).error(errorCallback);*/
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