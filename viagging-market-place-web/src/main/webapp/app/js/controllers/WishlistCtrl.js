marketPlaceApp.controller('WishlistCtrl', ['$scope', 'wishListService', 'wishlist', function($scope, wishListService, wishlist){
	$scope.wishList = wishlist;
}]);