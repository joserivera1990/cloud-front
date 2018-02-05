providersApp.controller('SearchCtrl', ['$scope', '$http','ngDialog','$rootScope', 'userService', function($scope, $http,ngDialog, $rootScope, userService) {
	$scope.idEspecifico = '1';
	$scope.name;
	$scope.lastName;
	$scope.filtrarnombre = "";
//	$rootScope.respuestaCreacion = "";
	$scope.chooseservices=[];
	$scope.ocultarSeccionAdicionarPaquete = true;
	$scope.onlyNumbers = /^\d+$/;
	$scope.servicio = {
		activo: false,
		id : 0,
		precio:0,
		usuario: {
			id: ""
		}
	}

	$scope.getCategory = function() { 
		console.log("ingreso a categoria");

		$http.get('/viagging-providers-web/getCategory').
		success(function(data, status, headers, config) {
			console.log(status);
			$scope.category = data;
			console.log(data);
		}).
		error(function(data, status, headers, config) {
			// log error
		}); 
		console.log('despues de llamar');
	}



	$scope.getServices = function(idCategoria) { 	
		console.log('getServices'+idCategoria); 
		$http.get('/viagging-providers-web/getServices',{
			params: { idCategory: idCategoria }
		}).success(function(data, status, headers, config) {
			console.log(status);
			console.log(data);
			$scope.listservices = data;
			for (var i=0;i<$scope.chooseservices.length;i++){
				for (var j=0;j<$scope.listservices.length;j++){
					if($scope.chooseservices[i].id == $scope.listservices[j].id){
						$scope.listservices[j].datosServicio = true;
					}
				}	    	  
			}
		}).
		error(function(data, status, headers, config) {
		}); 

	}

	$scope.especifico = function(id,idCategoria) { 	
		$rootScope.idEspecifico = id;
		if(idCategoria == "01"){
			ngDialog.open({ template: 'template/html/transporte.html', className: 'ngdialog-theme-default' });
		}else if(idCategoria == "02"){
			ngDialog.open({ template: 'template/html/alojamiento.html', className: 'ngdialog-theme-default' });
		}else if(idCategoria == "03"){
			ngDialog.open({ template: 'template/html/paseoecologico.html', className: 'ngdialog-theme-default' });
		}else if(idCategoria == "04"){
			ngDialog.open({ template: 'template/html/alimentacion.html', className: 'ngdialog-theme-default' });
		}
	}



	$scope.saveServicesTemp = function() { 	
		for (var i=0;i<$scope.listservices.length;i++){
			var flagExist = false;
			if($scope.listservices[i].datosServicio){
				for (var j=0;j<$scope.chooseservices.length;j++){
					if($scope.listservices[i].id == $scope.chooseservices[j].id){
						flagExist = true;		    	    	   
					}
				}
				if(!flagExist){
					$scope.chooseservices.push($scope.listservices[i]);
				}
			}

		}	
		$scope.ocultarSeccionAdicionarPaquete = false;
	}


	$scope.getDatosTransporte = function() { 
		console.log("transporte");
		console.log($rootScope.idEspecifico);
		$http.get('/viagging-providers-web/getServiceTransport',{
			params: { idService: $rootScope.idEspecifico }
		}).success(function(data, status, headers, config) {
			console.log(status);
			$scope.transporte = data;
			console.log(data);
		}).
		error(function(data, status, headers, config) {
		}); 
		console.log('despues de llamar');
	}


	$scope.getDatosAlojamiento = function() { 
		console.log("Alojamiento");
		console.log($rootScope.idEspecifico);
		$http.get('/viagging-providers-web/getServiceAlojamiento',{
			params: { idService: $rootScope.idEspecifico }
		}).success(function(data, status, headers, config) {
			console.log(status);
			$scope.alojamiento = data;
			console.log(data);
		}).
		error(function(data, status, headers, config) {
		}); 
	}


	$scope.getDatosAlimentacion = function() { 
		console.log("Alimentacion");
		console.log($rootScope.idEspecifico);
		$http.get('/viagging-providers-web/getServiceAlimentacion',{
			params: { idService: $rootScope.idEspecifico }
		}).success(function(data, status, headers, config) {
			console.log(status);
			$scope.alimentacion = data;
			console.log(data);
		}).
		error(function(data, status, headers, config) {
		}); 
		console.log('despues de llamar');
	}


	$scope.getDatosPaseoEcologico = function() { 
		console.log($rootScope.idEspecifico);
		$http.get('/viagging-providers-web/getServicePaseoEcologico',{
			params: { idService: $rootScope.idEspecifico }
		}).success(function(data, status, headers, config) {
			console.log(status);
			$scope.paseoEcologico = data;
			console.log(data);
		}).
		error(function(data, status, headers, config) {
		}); 
	}


	$scope.createPackage = function() { 
		console.log("crear paquete");
		console.log($scope.paquete);
		if($scope.paquete.precio > 2147483647){
			$rootScope.respuestaCreacion = "Precio debe ser menor a 2147483648";
			ngDialog.open({ template: 'popup.html', className: 'ngdialog-theme-popup' });
		}else{

			$scope.paquete.servicios = $scope.chooseservices;
			$http.post('/viagging-providers-web/addPackage',$scope.paquete).
			success(function(data, status, headers, config) {
				console.log(status);
				$rootScope.respuestaCreacion = "Paquete Creado";
				ngDialog.open({ template: 'popup.html', className: 'ngdialog-theme-popup' });
				$scope.paquete.precio = "";
				$scope.paquete.nombre = "";
				$scope.paquete.descripcion = "";
				console.log($rootScope.respuestaCreacion);

			}).
			error(function(data, status, headers, config) {
				$rootScope.respuestaCreacion = "Error al crear paquete";
				ngDialog.open({ template: 'popup.html', className: 'ngdialog-theme-popup' });
			}); 
		}

	}

	$scope.desasociarServicio = function(id) { 
		console.log("desasociarServicio"+id);
		for (var j=0;j<$scope.chooseservices.length;j++){
			if($scope.chooseservices[j].id == id){
				$scope.chooseservices.splice(j, 1);	
				break;
			}
		}
		if($scope.chooseservices.length == 0){
			$scope.ocultarSeccionAdicionarPaquete = true;
		}
	}

	$scope.getPackages = function(filtro) { 
		console.log("filtro"+filtro);
		$http.get('/viagging-providers-web/getPackages',{
			params: { filtro: filtro }
		}).success(function(data, status, headers, config) {
			console.log(status);
			$scope.listPackages = data;
			console.log(data);
		}).
		error(function(data, status, headers, config) {
			console.log(data);
			console.log(status);
			$scope.listPackages = [];
		}); 
		console.log('despues de llamar Packages');
	}


	$scope.getPackage = function(idPaquete) { 
		alert(idPaquete);

		/*$http.get('/viagging-providers-web/getPackage',{
			params: { idPackage: idPaquete }
		}).
		success(function(data, status, headers, config) {
			console.log(status);
			$scope.listaServicios = data;
			console.log(data);
		}).
		error(function(data, status, headers, config) {

		}); 
		console.log('despues de llamar Packages');*/
	}
	
	$scope.activarServicio = function(idServicio,estado) { 
		console.log("id"+idServicio);
		console.log("estado"+estado);
		$scope.servicio.id = idServicio;
		$scope.servicio.activo = estado;
		$scope.servicio.usuario.id=$scope.userData.id;
		$http.post('/viagging-providers-web/activeService', angular.toJson($scope.servicio), {
			headers: {"Content-Type": "application/json"},
			transformRequest: angular.identity
		}).success(function(data, status, headers, config) {
			alert("Transacción exitosa");
			for (var i=0;i<$scope.listservices.length;i++){
  	    	  if($scope.listservices[i].id == idServicio){
  	    		  $scope.listservices[i].activo = estado;
  	    		  break;
  	    	  }	    	    	  
  	      }   	    	  
		}).error(function(data, status, headers, config) {}); 
    }
	
	$scope.eliminarServicio = function(idServicio) { 
		$http.post('/viagging-providers-web/deleteService', idServicio, {
			headers: {"Content-Type": "application/json"},
			transformRequest: angular.identity
		}).success(function(data, status, headers, config) {
			alert("Transacción exitosa");
			var index = 0;
			for (var i=0;i<$scope.listservices.length;i++){
  	    	  if($scope.listservices[i].id == idServicio){
  	    		 index = i;
  	    		  break;
  	    	  }	    	    	  
  	      	}
			$scope.listservices.splice(index, 1);
		}).error(function(data, status, headers, config) {}); 
    }
	
	$scope.activatePackage = function(id,estado) { 
		   $scope.paquete.id = id;
		   $scope.paquete.activo = estado;
		   console.log("id"+id);
		   console.log("estado"+estado);
			 $http.post('/viagging-providers-web/activatePackage',$scope.paquete).
			 success(function(data, status, headers, config) {
	    	      console.log(status);
	    	      alert("Transacción exitosa");
	    	      for (var i=0;i<$scope.listservices.length;i++){
	    	    	  if($scope.listservices[i].id == id){
	    	    		  $scope.listservices[i].activo = estado;
	    	    		  break;
	    	    	  }	    	    	  
	    	      }
         }).
       error(function(data, status, headers, config) {
     	  alert("Error al activar/desactivar");
         });
	     }

}]);
