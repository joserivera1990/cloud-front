providersApp.factory('storageService', ['$window', function($window) {
    
    var sessionStorage;

    window.sessionStorageMap = {};

    /**
     * @ngdoc function
     * @description validates if the browser supports session storage
     */
    function isSessionStorageSupported() {
        var testKey = 'test', storage = $window.sessionStorage;
        try {
            storage.setItem(testKey, '1');
            storage.removeItem(testKey);
            return true;
        } catch (error) {
            return false;
        }
    }

    if (isSessionStorageSupported()) {
    	sessionStorage = $window.sessionStorage;
    } else {
    	sessionStorage = {
            /**
             * @ngdoc method
             * @description clears the session storage fallback
             */
            clear: function () {
                window.sessionStorageMap = {};
            },
            /**
             * @ngdoc method
             * @description gets an item from the session storage fallback
             */
            getItem: function (key) {
                return window.sessionStorageMap[key];
            },
            /**
             * @ngdoc method
             * @description removes an item from the session storage fallback
             */
            removeItem: function (key) {
                window.sessionStorageMap[key] = {};
            },
            /**
             * @ngdoc method
             * @description stores an item in the session storage fallback
             */
            setItem: function (key, data) {
                window.sessionStorageMap[key] = data;
            }
        };
    }
    
    return {
    	
        /**
         * @ngdoc method
         * @description returns whether the object with the given key is or not stored in the storage
         */
        hasObject: function (key) {
            return (sessionStorage.getItem(key) != null);
        },
        /**
         * @ngdoc method
         * @description returns the item with the given key
         */
        get: function (key) {
            return JSON.parse(sessionStorage.getItem(key));
        },
        /**
         * @ngdoc method
         * @descriptions sets the item with the given key
         */
        put: function (key, data) {
        	sessionStorage.setItem(key, JSON.stringify(data));
        },
        /**
         * @ngdoc method
         * @description removes the item with the given key
         */
        remove: function (key) {
        	sessionStorage.removeItem(key);
        },
        /**
         * @ngdoc method 
         * @description removes all the items which were stored
         */
        clearAll: function () {
        	sessionStorage.clear();
        }
    };
    
}]);