providersApp.service('userService', [ 'storageService', function(storageService){

	var userService = {
		
		setUserData : function(userData){
			storageService.put('userData', userData);
		},
			
		getUserData : function(){
			return storageService.get('userData');
		},
		
		removeUserData : function(){
			storageService.remove('userData');
		}

	};
	
	return userService;
	
}]);