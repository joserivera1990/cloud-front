'use strict';

var providersApp = angular.module('viaggingApp', ['ui.router', 'ui.bootstrap','ngDialog', 'angularFileUpload', 'ngAnimate']);

providersApp.config(['$stateProvider', function($stateProvider){
	$stateProvider
		.state("home", {
			url: "/home",
			templateUrl: 'template/html/login.html',
			controller: 'LoginCtrl'
		})
		.state("consultar", {
			url: "/consultar",
			templateUrl: 'template/html/consultarservicios.html',
			controller: 'SearchCtrl',
		})
		.state("alojamiento", {
			url: "/alojamiento",
			templateUrl: 'template/html/crearalojamiento.html',
			controller: 'AlojamientoCtrl',
		})
		.state("alimentacion", {
			url: "/alimentacion",
			templateUrl: 'template/html/crearalimentacion.html',
			controller: 'AlimentacionCtrl',
		})
		.state("turismo", {
			url: "/turismo",
			templateUrl: 'template/html/crearturismo.html',
			controller: 'TurismoCtrl',
		})
		.state("transporte", {
			url: "/transporte",
			templateUrl: 'template/html/creartransporte.html',
			controller: 'TransporteCtrl',
		})
		.state("consultarpaquete", {
			url: "/consultarpaquete",
			templateUrl: 'template/html/consultaPaquete.html',
			controller: 'samplecontroller',
		})
		.state("activarpaquete", {
			url: "/activarpaquete",
			templateUrl: 'template/html/activarPaquete.html',
			controller: 'samplecontroller',
		})
		.state("eliminarpaquete", {
			url: "/eliminarpaquete",
			templateUrl: 'template/html/eliminarPaquete.html',
			controller: 'samplecontroller',
		})
		.state("actualizarpaquete", {
			url: "/actualizarpaquete",
			templateUrl: 'template/html/actualizarPaquete.html',
			controller: 'samplecontroller',
		})
		.state("paquete", {
			url: "/paquete",
			templateUrl: 'template/html/crearPaquete.html',
			controller: 'samplecontroller',
		})
		.state("pregunta", {
			url: "/pregunta",
			templateUrl: 'template/html/consultarpreguntas.html',
			controller: 'PreguntasCtrl',
		})
		.state("responderpregunta", {
			url: "/responderpregunta",
			templateUrl: 'template/html/responderPregunta.html',
			controller: 'PreguntasCtrl',
		})
		.state("profile", {
			url: "/profile",
			templateUrl: 'template/html/perfil.html',
			controller: 'UsuarioCtrl',
		})
		.state("busqueda", {
			url: "/busqueda",
			templateUrl: 'template/html/reporte.html',
			controller: 'ReporteCtrl',
		})
		.state("mensajes", {
			url: "/mensajes",
			templateUrl: 'template/html/mensajes.html',
			controller: 'MensajesCtrl',
		});
}]);

providersApp.run(['$state', function run($state) {
	$state.go("home");
}]);
