marketPlaceApp.service('messagesService', ['$http', '$q', 'userService', 'messageHelper', 
    function($http, $q, userService, messageHelper){
	
	var userData = userService.getUserData();
	
	var messagesService = {
			
		getConversationsByUserId : function(){
			return $http({
	            url: "/viagging-api-message/user/" + userData.id + "/conversations",
	            method: "GET",
	            cache: false
	        }).then(function successCallback(response) {
	        	if(angular.isArray(response.data)){
	        		var conversations = messageHelper.buildConversationListFromResponse(response.data);
	        		return $q.resolve(conversations);
	        	} else {
	        		return $q.reject(response.data);
	        	}
	        }, function errorCallback(response) {
	        	return $q.reject(response.data);
	        });
		},
		
		getConversationById : function(conversationId){
			return $http({
	            url: "/viagging-api-message/conversations/" + conversationId,
	            method: "GET",
	            cache: false
	        }).then(function successCallback(response) {
	        	if(angular.isObject(response.data)){
	        		var conversation = messageHelper.buildConversationFromResponse(response.data);
	        		return $q.resolve(conversation);
	        	} else {
	        		return $q.reject(response.data);
	        	}
	        }, function errorCallback(response) {
	        	return $q.reject(response.data);
	        });
		},
		
		sendMessageToConversation : function(message, conversationId, successCallback, errorCallback){
			return $http({
	            url: "/viagging-api-message/conversations/" + conversationId + "/message",
	            method: "POST",
	            cache: false,
	            data: message
	        }).success(successCallback).error(errorCallback);
		},
		
		createConversation : function(conversacion, successCallback, errorCallback){
			return $http({
	            url: "/viagging-api-message/conversations/",
	            method: "POST",
	            cache: false,
	            data: conversacion
	        }).success(successCallback).error(errorCallback);
		}
	};
	
	return messagesService;
}]);