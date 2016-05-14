angular.module('iTalentApp')
    .factory('subscriberDocentService', ['$resource', '$q', '$http', 'GLOBALS', function ($resource, $q, $http, GLOBALS) {
        return {
            save: function (id, percentage) {
            	   return $http({
            	        url: GLOBALS.baseURL + 'subscriberDocent/save/' + id + '/' + percentage,
            	        method: "POST"
            	    })
            }
        }
    }]);
