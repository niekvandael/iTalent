/**
 * Created by arjen on 18/04/2016.
 */

angular.module('iTalentApp')
    .factory('likeService', ['$resource', '$q', '$http', 'GLOBALS', function ($resource, $q, $http, GLOBALS) {
        return {
            saveOrUpdate: function (id) {
            	   return $http({
            	        url: GLOBALS.baseURL + 'likes/likeProject',
            	        method: "POST",
            	        data: id
            	    })
            }
        }
    }]);
