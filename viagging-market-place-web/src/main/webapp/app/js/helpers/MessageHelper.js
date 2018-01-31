marketPlaceApp.factory('messageHelper',[ 'userService', function(userService){

    'use strict';
    
	var userData = userService.getUserData();

    var messageHelper = {
		
		buildConversationListFromResponse : function(conversationListResponse){
			var conversationList = [];
			if(conversationListResponse.length > 0){
				angular.forEach(conversationListResponse, function(conversationResponse){
					var conversation = messageHelper.buildConversationFromResponse(conversationResponse);
					conversationList.push(conversation);
				});
			}
			return conversationList;
		},
    		
		buildConversationFromResponse : function(conversationResponse){
			var userId = userData.id;
			var userIdWith = null;
			
			if(userId == conversationResponse.usuario1.id){
				userIdWith = conversationResponse.usuario2.id;
			} else {
				userIdWith = conversationResponse.usuario1.id;
			}
			
			var userNameWith = messageHelper.buildUserName(userIdWith, conversationResponse);
				
			var lastMessage = "";
			var lastMessageDate = "";
			var messages = [];
			if(conversationResponse.mensajes.length > 0){
				var lastMessageObj = conversationResponse.mensajes[conversationResponse.mensajes.length - 1];
				lastMessage = lastMessageObj.mensaje;
				lastMessageDate = lastMessageObj.fecha;
				angular.forEach(conversationResponse.mensajes, function(messageResponse){
					var message = messageHelper.buildMessageFromResponse(messageResponse, conversationResponse);
					messages.push(message);
				});
			}
			
			var conversation = {
				id: conversationResponse.id,
				userNameWith : userNameWith,
				lastMessage: lastMessage,
				lastMessageDate: lastMessageDate,
				messages: messages
			};
			return conversation;
		},
		
		buildMessageFromResponse : function(messageResponse, conversationResponse){
			var message = {
				userName: messageHelper.buildUserName(messageResponse.idUsuario, conversationResponse),
				message: messageResponse.mensaje,
				date: messageResponse.fecha
			};
			return message;
		},
		
		buildUserName : function(userId, conversation){
			var userName = conversation.usuario1.primerNombre + " " + conversation.usuario1.primerApellido;
			if(userId == conversation.usuario2.id){	
				userName = conversation.usuario2.primerNombre + " " + conversation.usuario2.primerApellido;
			}
			return userName;
		}
        
    };
    
    return messageHelper;
}]);