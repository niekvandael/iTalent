/**
 * Created by arjen on 19/04/2016.
 */
angular.module('iTalentApp')
    .factory('userService', ['$resource', '$q', '$http', '$rootScope' , function ($resource, $q, $http, $rootScope) {

        return {
            refresh: function () {
            	$http.get('user', {
                }).then(function(response) {
                    $rootScope.authenticated = response.data.authenticated;

                    if (response.data.authenticated) {
                        /* When success, do this */
                        $rootScope.role = response.data.authorities[0].authority;
                        $rootScope.user = {};
                        $rootScope.user.displayName = response.data.name;
                    }
                }, function() {
                    $rootScope.authenticated = false;
                });
            }
        }
    }]);
