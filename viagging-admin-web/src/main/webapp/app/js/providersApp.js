'use strict';

var providersApp = angular.module('viaggingApp', ['ui.router', 'ui.bootstrap','ngDialog', 'angularFileUpload']);

providersApp.config(['$stateProvider', function($stateProvider){
	$stateProvider
		.state("home", {
			url: "/home",
			templateUrl: 'template/html/login.html',
			controller: 'LoginCtrl'
		})
		.state("consultar", {
			url: "/consultar",
			templateUrl: 'template/html/consultarusuario.html',
			controller: 'UsuarioCtrl',
		})
		.state("actualizar", {
			url: "/actualizar",
			templateUrl: 'template/html/actualizarusuario.html',
			controller: 'UsuarioCtrl',
		})
		.state("eliminar", {
			url: "/eliminar",
			templateUrl: 'template/html/eliminarusuario.html',
			controller: 'UsuarioCtrl',
		})
		.state("crear", {
			url: "/crear",
			templateUrl: 'template/html/crearusuario.html',
			controller: 'UsuarioCtrl',
		})
		.state("transacciones", {
			url: "/transacciones",
			templateUrl: 'template/html/transaccion.html',
			controller: 'TransaccionCtrl',
		});
}]);

providersApp.run(['$state', function run($state) {
	$state.go("home");
}]);