angular.module('iTalentApp')
    .controller('loginController', ['$scope', '$rootScope', '$http', '$location', 'toastr', '$translate', function ($scope, $rootScope, $http, $location, toastr, $translate) {

        $scope.loginSubmit = function () {
            
            /* Do authentication check */
            var authenticate = function(credentials, callback) {
                var headers = $scope.credentials ? {
                    authorization : "Basic "
                    + btoa($scope.credentials.username + ":"
                        + $scope.credentials.password)
                } : {};

                $http.get('user', {
                    headers : headers
                }).then(function(response) {
                    if (response.data.name) {
                        /* When success, do this */
                        $rootScope.authenticated = true;
                        $rootScope.role = response.data.authorities[0].authority;
                        $rootScope.user={};
                        $rootScope.user.displayName = $scope.credentials.username;
                        $location.path('/');
                    } else {
                        /* When failed, do this */
                        $rootScope.authenticated = false;
                    }
                    callback && callback($rootScope.authenticated);
                }, function() {
                    toastr.error($translate.instant('views.messages.error_login'), $translate.instant('views.messages.fail'));
                    $scope.credentials = {};
                    $rootScope.authenticated = false;
                    callback && callback(false);
                });
            };

            authenticate();
        };

        $scope.logout = function () {
            $http.post('logout', {}).finally(function() {
                $rootScope.user.displayName = '';
                $rootScope.role = '';
                $rootScope.authenticated = false;
                $location.path('/');
            });
        }
    }]);
