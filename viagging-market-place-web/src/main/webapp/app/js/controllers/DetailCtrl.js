marketPlaceApp.controller('DetailCtrl', ['$scope', '$state', 'product','ngCart', 'wishListService', 'userService', 'productsService', 'configService', 'messagesService', 'weather',
     function($scope, $state, product, ngCart, wishListService, userService, productsService, configService, messagesService, weather){

	'use strict';

	$scope.addComment = function(){
		$scope.comentarioCalificacion.usuario = userService.getUserData();
		productsService.addCommentToProduct($scope.comentarioCalificacion, $scope.product.id,
			function(){
				alert("Gracias por agregar tu comentario y calificación!");

				$scope.product.comentarios.push(angular.copy($scope.comentarioCalificacion));
				$scope.comentarioCalificacion.comentario = "";
				$scope.comentarioCalificacion.calificacion = 5;
			},
			function(){
				alert("No ha sido posible agregar tu comentario y calificación. Inténtalo de nuevo!");
			});
	};

	$scope.addQuestion = function(){
		$scope.preguntaProducto.usuario = userService.getUserData();
		productsService.addQuestionToProduct($scope.preguntaProducto, $scope.product.id,
			function(){
				alert("Tu pregunta ha sido agregada!");

				$scope.product.preguntas.push(angular.copy($scope.preguntaProducto));
				$scope.preguntaProducto.pregunta = "";
			},
			function(){
				alert("No ha sido posible agregar tu pregunta. Inténtalo de nuevo!");
			});
	};

	$scope.inCart = function(){
        return ngCart.getItemById($scope.product.id);
    };

    $scope.addWishToList = function(){
    	if(product.servicio != null)

    	var listaDeseo = {
    		idUsuario : userService.getUserData().id,
    		idPaquete : "",
    		idServicio : ""
    	};

    	wishListService.addWishToList(listaDeseo);
    };
    
    var createConversationSuccessCallback = function(conversacion){
    	$state.go("message-detail", {"conversationId" : conversacion.id});
    };
    
    var createConversationErrorCallback = function(){
    	alert("Ha ocurrido un error, intenta de nuevo.");
    };
    
    $scope.createConversation = function(proveedorId){
    	//alert(proveedorId);
    	var conversacion = {
			usuario1: {
				id: userService.getUserData().id
			},
			usuario2 : {
				id: proveedorId
			}
    	};
    	
    	messagesService.createConversation(conversacion, createConversationSuccessCallback, createConversationErrorCallback);
    };

    var initDetailCtrl = function(){
    	$scope.variability = configService.getVariability();
    	$scope.ngCart = ngCart;
    	$scope.product = product;
    	$scope.weather = weather;
    	$scope.comentarioCalificacion = {};
    	$scope.preguntaProducto = {};

    	//Carousel
    	$scope.noWrapSlides = false;
    	$scope.active = 0;
    	$scope.slides = [];
    	var imagenes = product.imagenes;
    	var i=0;
    	angular.forEach(imagenes, function(imagen){
    		var obj = {
				image : imagen,
				id: i++
    		};
    		$scope.slides.push(obj);
    	});
    }();
}]);