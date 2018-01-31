marketPlaceApp.controller('MessagesCtrl', ['$scope', 'conversations', function($scope, conversations){

	initMessagesCtrl = function(){
		$scope.conversations = conversations;
	}();
	
}]);