marketPlaceApp.service('userService', [ 'storageService', '$http', '$q', function(storageService, $http, $q){

	var userService = {
		
		setUserData : function(userData){
			storageService.put('userData', userData);
		},
			
		getUserData : function(){
			return storageService.get('userData');
		},
		
		removeUserData : function(){
			storageService.remove('userData');
		},
		
		updateUser : function(user, successCallback, errorCallback){
			return $http({
	            url: "/viagging-providers-web/updateUser",
	            method: "PUT",
	            cache: false,
	            data: user
	        }).success(function(){
	        	storageService.put('userData', user);
	        	successCallback();
	        }).error(errorCallback);
		}

	};
	
	return userService;
	
}]);