marketPlaceApp.filter("productsFilter", function(){
	return function (products, searchText, categoriesArray) {
        var returnArray = [],
        // Set searchText if null
        searchText = searchText ? searchText : "",
        // Split on single or multi space
        splitext = searchText.toLowerCase().split(/\s+/),
        // Build Regexp with Logical AND using "look ahead assertions"
        regexp_and = "(?=.*" + splitext.join(")(?=.*") + ")",
        // Build Regexp with logicial OR
        regexp_or = searchText.toLowerCase().replace(/\s+/g, "|"),
        // Compile the regular expression
        re = new RegExp(regexp_and, "i");

        for (var x = 0; x < products.length; x++) {
        	var add = false;
        	var product = products[x];        	
            var services = product.servicios;
            if(services && services.length > 0){
            	for(var y = 0; y < services.length; y++){
            		var textFound = false;
            		var categoryFound = false;
            		var service = services[y];
            		
            		//Search by text
            		if (re.test(service.nombre) || re.test(service.descripcionCorta)) {
                    	textFound = true;
                    }
            		
            		//Search by category
            		if(categoriesArray && categoriesArray.length > 0){
            			for(var z = 0; z < categoriesArray.length; z++){
            				var category = categoriesArray[z];
            				if(category === service.categoria){
            					categoryFound = true;
            				}
            			}
            		} else {
            			categoryFound = true;
            		}
            		
            		add = textFound && categoryFound;
            	}
            }
            
            if(add){
            	returnArray.push(product);
            }
        }
        return returnArray;
	};
});