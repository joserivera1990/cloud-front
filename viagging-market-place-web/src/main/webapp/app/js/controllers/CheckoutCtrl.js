marketPlaceApp.controller('CheckoutCtrl', ['$scope', 'ngCart', 'userService', '$state', 'paymentsService',
    function($scope, ngCart, userService, $state, paymentsService){
	
	'use strict';
	
	$scope.showGeneralData = function(){
		$scope.isGeneralDataVisible = true;
		$scope.isPaymentMethodsVisible = false;
	};
	
	$scope.showPaymentMethods = function(){
		$scope.isGeneralDataVisible = false;
		$scope.isPaymentMethodsVisible = true;
	};
	
	var successCallback = function (data){
		$scope.ngCart.empty();
		alert("Tu compra se ha realizado con éxito!");
		$state.go("order-response", { orderId : data.id });
	};
	
	var errorCallback = function(data, status, header, config){
		if(status == 507){
			alert("Ha excedido la capacidad de compra del servicio");
		}else{
			alert("Ha ocurrido un error durante el procesamiento de tu pago. Intenta de nuevo.");
		}
	};
	
	$scope.submitPayment = function(){
		var productsInCart = $scope.ngCart.getItems();
		$scope.payment.idUsuario = $scope.userData.id;
		$scope.payment.valorTotal = $scope.ngCart.getSubTotal();
		$scope.payment.productos = [];
		angular.forEach(productsInCart, function(product) {
			var producto = {
				id : product.getId(),
				cantidad: product.getQuantity()
			};
			$scope.payment.productos.push(producto);
		});
		
		paymentsService.submitPayment($scope.payment, successCallback, errorCallback);
	};
	
	var initCheckoutCtrl = function(){
		$scope.isGeneralDataVisible = true;
		$scope.isPaymentMethodsVisible = false;
		
		$scope.ngCart = ngCart;
		
		$scope.userData = userService.getUserData();
	}();
	
}]);