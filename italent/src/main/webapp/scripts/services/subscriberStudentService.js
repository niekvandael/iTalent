angular.module('iTalentApp')
    .factory('subscriberStudentService', ['$resource', '$q', '$http', 'GLOBALS', function ($resource, $q, $http, GLOBALS) {
        return {
            save: function (id, hours) {
            	   return $http({
            	        url: GLOBALS.baseURL + 'subscriberStudent/save/' + id + '/' + hours,
            	        method: "POST"
            	    })
            }
        }
    }]);
