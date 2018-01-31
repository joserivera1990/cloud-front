marketPlaceApp.controller('MessageDetailCtrl', ['$scope', 'conversation', 'messagesService', 'userService',
    function($scope, conversation, messagesService, userService){
	
	$scope.sendMessage = function(){
		$scope.message.idUsuario = userService.getUserData().id;
		messagesService.sendMessageToConversation($scope.message, $scope.conversation.id,
			function(newMessage){
				alert("Tu mensaje ha sido enviado con éxito!");
				var message = {
					userName: userService.getUserData().primerNombre + " " + userService.getUserData().primerApellido,
					message: angular.copy(newMessage.mensaje),
					date: newMessage.date
				};
				$scope.conversation.messages.push(message);
				$scope.message.mensaje = "";
			},
			function(){
				alert("No ha sido posible enviar tu mensaje, intenta de nuevo.");
			});
	};
	
	initMessageDetailCtrl = function(){
		$scope.conversation = conversation;
		$scope.message = {};
	}();
	
}]);