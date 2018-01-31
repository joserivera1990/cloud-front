'use strict';

var marketPlaceApp = angular.module('viaggingApp', ['ui.router', 'ui.bootstrap', 'ngCart', 'ngHello']);

marketPlaceApp.config(['$stateProvider', 'helloProvider', function($stateProvider, helloProvider){

	helloProvider.init({
        twitter: 'MBctR7IG53Xp0p2vdlg4whr6L',
        facebook: '1528185660824408'
    },{
    	scope : 'email'
    });
	
	$stateProvider
		.state("home", {
			url: "/home",
			templateUrl: 'views/catalogue.html',
			resolve: {
				config : ['configService', function(configService){
					return configService.initMarketPlaceConfig();
				}],
				products : ['productsService', function(productsService){
					return productsService.getAllProducts();
				}]
			},
			controller: 'CatalogueCtrl',
			reloadOnSearch: true
		})
		.state("search", {
			url: "/search",
			templateUrl: 'views/search.html',
			params: { busqueda : null },
			resolve: {
				config : ['configService', function(configService){
					return configService.initMarketPlaceConfig();
				}],
				products : ['productsService', '$stateParams', function(productsService, $stateParams){
					return productsService.getAllProducts();
				}]
			},
			controller: 'SearchCtrl'
		})
		.state("detail", {
			url: "/detail/:productId",
			templateUrl: 'views/detail.html',
			resolve: {
				config : ['configService', function(configService){
					return configService.initMarketPlaceConfig();
				}],
				product : ['productsService', '$stateParams', function(productsService, $stateParams){
					return productsService.getProductById($stateParams.productId);
				}],
				weather : ['weatherService', function(weatherService){
					return weatherService.getWeather();
				}]
			},
			controller: 'DetailCtrl'
		})
		.state("login", {
			url: "/login",
			templateUrl: '../app/views/login.html',
			resolve: {
				config : ['configService', function(configService){
					return configService.initMarketPlaceConfig();
				}]
			},
			controller: 'LoginCtrl'
		})
		.state("register", {
			url: "/register",
			templateUrl: '../app/views/register.html',
			resolve: {
				config : ['configService', function(configService){
					return configService.initMarketPlaceConfig();
				}]
			},
			controller: 'RegisterCtrl'
		})
		.state("cart", {
			url: "/cart",
			templateUrl: '../app/views/cart.html'
		})
		.state("checkout", {
			url: "/checkout",
			templateUrl: '../app/views/checkout.html',
			controller: 'CheckoutCtrl'
		})
		.state("order-response", {
			url: "/checkout/order/:orderId",
			templateUrl: '../app/views/order-response.html',
			resolve: {
				order : ['ordersService', '$stateParams', function(ordersService, $stateParams){
					return ordersService.getOrderById($stateParams.orderId);
				}]
			},
			controller: 'OrderResponseCtrl'
		})
		.state("wishlist", {
			url: "/user/wishlist",
			templateUrl: '../app/views/wishlist.html',
			resolve: {
				wishlist : ['wishListService', function(wishListService){
					return wishListService.getAllWishList();
				}]
			},
			controller: 'WishlistCtrl'
		})
		.state("profile", {
			url: "/user/profile",
			templateUrl: '../app/views/profile.html',
			controller: 'ProfileCtrl'
		})
		.state("messages", {
			url: "/user/messages",
			templateUrl: '../app/views/messages.html',
			resolve: {
				conversations : ['messagesService', function(messagesService){
					return messagesService.getConversationsByUserId();
				}]
			},
			controller: 'MessagesCtrl'
		})
		.state("message-detail", {
			url: "/user/messages/:conversationId",
			templateUrl: '../app/views/message-detail.html',
			resolve: {
				conversation : ['messagesService', '$stateParams', function(messagesService, $stateParams){
					return messagesService.getConversationById($stateParams.conversationId);
				}]
			},
			controller: 'MessageDetailCtrl'
			
		})
		.state("orders", {
			url: "/user/orders",
			templateUrl: '../app/views/orders.html',
			resolve: {
				orders : ['ordersService', function(ordersService){
					return ordersService.getOrdersByUsuarioId();
				}]
			},
			controller: 'OrdersCtrl'
		})
		.state("order-detail", {
			url: "/user/orders/detail/:orderId",
			templateUrl: '../app/views/order-detail.html',
			resolve: {
				order : ['ordersService', '$stateParams', function(ordersService, $stateParams){
					return ordersService.getOrderById($stateParams.orderId);
				}]
			},
			controller: 'OrderDetailCtrl'
		})
		.state("faq", {
			url: "/faq",
			templateUrl: '../app/views/faq.html',
			resolve: {
				faq : ['faqService', function(faqService){
					return faqService.getAllFaqs();
				}]
			},
			controller: 'FaqCtrl'
		})
		.state("contact", {
			url: "/contact",
			templateUrl: '../app/views/contact.html',
			controller: 'ContactCtrl'
		})
		.state("typography", {
			url: "/typography",
			templateUrl: '../app/views/typography.html'
		})
		.state("about", {
			url: "/about",
			templateUrl: '../app/views/about.html'
		});
}]);

marketPlaceApp.run(['$state', function run($state) {
	$state.go("home");
}]);