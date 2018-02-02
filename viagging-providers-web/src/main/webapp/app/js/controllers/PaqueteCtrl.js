providersApp.controller('samplecontroller', ['$scope', 'userService', '$http','ngDialog','$rootScope','$sce', function($scope, userService, $http,ngDialog, $rootScope,$sce) {
$scope.idEspecifico = '1';
$scope.name;
$scope.lastName;
$scope.filtrarnombre = "";
$scope.chooseservices=[];
$scope.ocultarSeccionAdicionarPaquete = true;
$scope.ocultarSeccionActualizarPaquete = true;
$scope.paquete = {
		precio: 0,
		nombre: "",
		descripcion: "",
		activo: false,
		id : 0,
		fechaInicio: "",
		fechaFin: "",
		capacidad: "",
		usuario: {
			id: ""
		}
}

    $scope.$watch("ajaxURL", function (newValue, oldValue) {
        userData = userService.getUserData();
        idUser = userData.idUser;
        $http.get('http://localhost:8090/api/events/user/'+idUser).
        success(function(data, status, headers, config) {
            $scope.events = data;
        }).
        error(function(data, status, headers, config) {
        });
    });


$scope.reporte = {
		tipo: "QUERY",
		fechaInical: "2015-01-08",
		fechaFinal: "2016-05-10",
		 "listaServicios":[
		                   {"id":1}, 
		                   {"id":2}, 
		                   {"id":3}
		                  ],
        "listaPaquetes":[
        {"id":325}
        ]
}


   $scope.getCategory = function() { 
		 $http.get('/viagging-providers-web/getCategory').
		    success(function(data, status, headers, config) {
		    	console.log(status);
		      $scope.category = data;
		      console.log(data);
		    }).
		    error(function(data, status, headers, config) {
		    }); 
		    console.log('despues de llamar');
     }



	$scope.getServices = function(idCategoria) { 	
	    console.log('getServices'+idCategoria); 
	    $http.get('/viagging-providers-web/getServicesByProveedor',{
	        params: { 
	        	idCategory: idCategoria,
	        	idProveedor :  $scope.userData.id
	        	}
	    }).success(function(data, status, headers, config) {
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
	    console.log('especifico'+id + "---"+idCategoria); 

	    if(idCategoria == "01"){
	         ngDialog.open({ template: 'template/html/transporte.html', className: 'ngdialog-theme-default' });
	    }else if(idCategoria == "02"){
	    	ngDialog.open({ template: 'template/html/alojamiento.html', className: 'ngdialog-theme-default' });
	    }else if(idCategoria == "03"){
	    	ngDialog.open({ template: 'template/html/paseoEcologico.html', className: 'ngdialog-theme-default' });
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
		console.log($scope.paquete);
		console.log("idUsuario"+$scope.userData.id);
		$scope.paquete.usuario.id = $scope.userData.id;
		if($scope.paquete.precio > 2147483647){
			alert("Precio debe ser menor a 2147483648");
		}else{
		
			$scope.paquete.servicios = $scope.chooseservices;
			 $http.post('/viagging-providers-web/addPackage',$scope.paquete).
				 success(function(data, status, headers, config) {
		    	console.log(status);
		    	alert("Paquete creado");
		    	$scope.paquete.precio = "";
		    	$scope.paquete.nombre = "";
		    	$scope.paquete.descripcion = "";
		    	$scope.paquete.fechaInicio = "";
		    	$scope.paquete.fechaFin = "";
		    	$scope.paquete.capacidad = "";
		    	console.log($rootScope.respuestaCreacion);
	
	        }).
	          error(function(data, status, headers, config) {
	        	  alert("Error al crear paquete");
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
	alert("getPackages")
           userData = userService.getUserData();
           idUser = userData.idUser;
           $http.get('http://localhost:8090/api/events/user/'+idUser).
           success(function(data, status, headers, config) {
               $scope.events = data;
               alert("j");
               console.info($scope.events);
           }).
           error(function(data, status, headers, config) {
           });
	     }
	   

	   $scope.getEvent = function(idEvento) {
		   alert(idEvento);
           $http.get('http://localhost:8090/api/events/'+idEvento).
           success(function(data, status, headers, config) {
               $scope.event = data;
               console.log("here");
               console.log($scope.event);
               $scope.ocultarSeccionActualizarPaquete = false;
           }).
           error(function(data, status, headers, config) {
           });
	     }
	   
	   $scope.login = function() { 
		   console.log('login');
			 $http.get('/viagging-providers-web/getPackage',{
			    	params: { idPackage: idPaquete }
			    }).
			    success(function(data, status, headers, config) {
			    	console.log(status);
			      $scope.listaServicios = data;
			      console.log(data);
			    }).
			    error(function(data, status, headers, config) {
			      // log error
			    }); 
			    console.log('despues de llamar Packages');
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
	    	      for (var i=0;i<$scope.listPackages.length;i++){
	    	    	  if($scope.listPackages[i].id == id){
	    	    		  $scope.listPackages[i].activo = estado;
	    	    		  break;
	    	    	  }	    	    	  
	    	      }
            }).
          error(function(data, status, headers, config) {
        	  alert("Error al activar/desactivar");
            });
	     }
	   
	   $scope.eliminatePackage = function(idEvent) {
		   $http({ url: 'http://localhost:8090/api/events/'+idEvent,
               method: 'DELETE',
               headers: {"Content-Type": "application/json;charset=utf-8"}
	       }).then(function(res) {
	    	   console.log(res); 
	    	   for (var i=0;i<$scope.events.length;i++){
	    	    	  if($scope.events[i].idEvent == idEvent){
	    	    		  $scope.events.splice(i, 1);
	    	    		  break;
	    	    	  }	    	    	  
	    	      }
	    	      alert("Eliminación exitosa");
	       }, function(error) {
	    	   alert("Error al eliminar");
	       });
		   
	     }

		$scope.updateEvent = function() {
			console.log($scope.event);
			console.log("idUsuario"+$scope.event.idUser);
			 $http.put('http://localhost:8090/api/events',$scope.event).
				success(function(data, status, headers, config) {
					console.log(status);
					console.log(data);
					alert("Evento actualizado");
					 $scope.ocultarSeccionActualizarPaquete = true;
			}).
			  error(function(data, status, headers, config) {
				  alert("Error al actualizar evento");
			});
		}
		
		
		$scope.generarReporte = function(filtro) { 
			console.log($scope.reporte);		
			$http.post('/viagging-api-report/createReport',$scope.reporte, {responseType: 'arraybuffer'})
			   .success(function (data) {
				   console.log(data);
			       var file = new Blob([data], {type: 'application/pdf'});
			       var fileURL = URL.createObjectURL(file);
			       window.open(fileURL);
			});
		}
		
		$scope.statusInitial
		
		$scope.statusInitial={opened:false};
		$scope.statusFinal={opened:false};
		
		$scope.today = function() {
			$scope.dtMin = new Date();
			$scope.dtMax = new Date();
		};
		$scope.today();

		$scope.clear = function () {
			$scope.dtMin = null;
			$scope.dtMax = null;
		};

		// Disable weekend selection
		$scope.disabled = function(date, mode) {
			return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
		};

//		$scope.toggleMin = function() {
//			$scope.minDate = $scope.minDate ? null : new Date();
//		};
//		$scope.toggleMin();
		$scope.maxDate = new Date(2020, 5, 22);
		$scope.minDate = new Date(2000, 1, 1);

		$scope.openInitial = function($event) {
			$scope.statusInitial.opened = true;
		};
		
		$scope.openFinal = function($event) {
			$scope.statusFinal.opened = true;
		};

		$scope.setDate = function(year, month, day) {
			$scope.dt = new Date(year, month, day);
		};

		$scope.dateOptions = {
				formatYear: 'yy',
				startingDay: 1
		};

		$scope.status = {
				opened: false
		};

		var tomorrow = new Date();
		tomorrow.setDate(tomorrow.getDate() + 1);
		var afterTomorrow = new Date();
		afterTomorrow.setDate(tomorrow.getDate() + 2);
		$scope.events =
			[
			 {
				 date: tomorrow,
				 status: 'full'
			 },
			 {
				 date: afterTomorrow,
				 status: 'partially'
			 }
			 ];

		$scope.getDayClass = function(date, mode) {
			if (mode === 'day') {
				var dayToCheck = new Date(date).setHours(0,0,0,0);

				for (var i=0;i<$scope.events.length;i++){
					var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

					if (dayToCheck === currentDay) {
						return $scope.events[i].status;
					}
				}
			}

			return '';
		};
   
}]);