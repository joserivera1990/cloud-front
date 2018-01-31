marketPlaceApp.factory('emailValidationHelper',[ function (){

        'use strict';

        var ATOM = "[^\\x00-\\x1F^\\(^\\)^\\<^\\>^\\@^\\,^\\;^\\:^\\\\^\\\"^\\.^\\[^\\]^\\s]";
        var DOMAIN = "(" + ATOM + "+(\\." + ATOM + "+)*";
        var IP_DOMAIN = "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";
        var MAX_LENGTH = 50;
        
        var emailPattern = new RegExp("^" + ATOM + "+(\\." + ATOM + "+)*@" + DOMAIN + "|" + IP_DOMAIN + ")$");
        var accentedCharactersPattern = /[àÀâÂäÄáÁéÉèÈêÊëËìÌîÎïÏòÒôÔöÖùÙûÛüÜçÇ’ñ]/;
        
        var emailValidationHelper = {

            validateEmail : function(emailAddress) {
            	
            	var validEmailStructure = emailPattern.test(emailAddress);
            	var hasAccentedCharacters = accentedCharactersPattern.test(emailAddress);
                
            	if(!validEmailStructure || hasAccentedCharacters || emailAddress.length>MAX_LENGTH){
                	return false;
            	}
            	
                return true;
            }
        };
        return emailValidationHelper;
}]);