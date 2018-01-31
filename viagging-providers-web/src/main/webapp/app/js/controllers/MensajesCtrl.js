providersApp.controller('MensajesCtrl', [
		'$scope',
		'FileUploader',
		'$http',
		'userService',
		function($scope, FileUploader, $http, userService) {

			$scope.message = {
				mensaje : "",
				idUsuario : 0
			};
			$scope.newConversation = {
				"usuario1" : {
					"id" : ""
				},
				"usuario2" : {
					"id" : ""
				}
			};

			$scope.idConversation = 0;
			$scope.listConversation = [];
			$scope.listUsers = [];
			$scope.listMessage = [];
			$scope.ocultarSeccionMensajes = true;
			$scope.ocultarEscribirMensaje = true;
			$scope.ocultarShowMensaje = true;
			$scope.ocultarEscribirMensajeProveedor = true;
			$scope.showedMessage;
			$scope.wroteMessage;
			$scope.ocultarNewConversation = true;
			$scope.ocultarBotonNewConversation =  false;
			$scope.ocultarBotonAtras = true;
			
			$scope.getMessageConversation = function(id) {
				$scope.idConversation = id;
				$scope.ocultarSeccionConversation = true;
				$scope.ocultarSeccionMensajes = false;
				$http.get('/viagging-api-message/conversations/' + id).success(
						function(data, status, headers, config) {
							$scope.listMessage = data.mensajes;
						}).error(function(data, status, headers, config) {
				});
			}

			$scope.getConversation = function() {
				$scope.ocultarMensaje = true;
				$scope.ocultarBotonAtras = false;
				$http.get(
						'/viagging-api-message/user/' + $scope.userData.id
								+ '/conversations').success(
						function(data, status, headers, config) {
							$scope.listConversation = data;
						}).error(function(data, status, headers, config) {
				});
			}

			$scope.sendMessage = function() {
				$scope.message.mensaje = $scope.wroteMessage;
				$scope.message.idUsuario = $scope.userData.id;
				$http.post(
						'/viagging-api-message/conversations/'
								+ $scope.idConversation + '/message',
						$scope.message).success(
						function(data, status, headers, config) {
							$scope.getMessageConversation(data.idConversacion);
							$scope.wroteMessage = "";
						}).error(function(data, status, headers, config) {
								alert("Error al crear mensaje");
				});
			}

			$scope.writeMessage = function() {
				$scope.wroteMessage = "";
				$scope.showedMessage = "";
				$scope.ocultarEscribirMensaje = false;
				$scope.ocultarShowMensaje = true;
				$scope.ocultarBotonAtras = true;
			}

			$scope.showMessage = function(message) {
				$scope.showedMessage = message;
				$scope.ocultarEscribirMensaje = true;
				$scope.ocultarShowMensaje = false;
			}

			$scope.beforeConversation = function() {
				$scope.ocultarEscribirMensaje = true;
				$scope.ocultarShowMensaje = true;
				$scope.ocultarSeccionConversation = false;
				$scope.ocultarSeccionMensajes = true;
			}

			$scope.newConveration = function() {
				$scope.ocultarEscribirMensaje = true;
				$scope.ocultarShowMensaje = true;
				$scope.ocultarSeccionConversation = true;
				$scope.ocultarSeccionMensajes = true;
				$scope.ocultarNewConversation = false;
				$scope.ocultarBotonAtras = false;
				$http.get('/viagging-providers-web/getUsers').success(
						function(data, status, headers, config) {
							$scope.listUsers = data;
							console.log(data);
						}).error(function(data, status, headers, config) {
					// log error
				});
			}

			$scope.crearConversacion = function(idUsuario) {
				console.log(idUsuario);
				$scope.ocultarNewConversation = true;
				$scope.newConversation.usuario1.id = $scope.userData.id;
				$scope.newConversation.usuario2.id = idUsuario;
				$scope.ocultarEscribirMensaje = true;
				$scope.ocultarShowMensaje = true;
				$scope.ocultarSeccionConversation = false;
				$scope.ocultarSeccionMensajes = true;
				$http.post('/viagging-api-message/conversations',
						$scope.newConversation).success(
						function(data, status, headers, config) {
							$scope.getConversation();
						}).error(function(data, status, headers, config) {
					alert("Error al crear mensaje");
				});
			}

		} ]);