marketPlaceApp.controller('FaqCtrl', ['$scope', 'faqService', function($scope, faqService){
	$scope.faqs = faqService.getFaqs();
}]);