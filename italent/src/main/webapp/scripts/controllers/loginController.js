angular.module('iTalentApp')
    .controller('loginController', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {
        // $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

        $scope.loginSubmit = function () {

            /**
             * 
             * Opmerkingen:
             * 
             * Ik heb de 'authenticated' variabele van mijn oorspronkelijk project gebruikt.
             * Waarschijnlijk is dit hetzelfde als Arjen's 'loggedIn' variabele en het mijne mag dan ook 
             * weggeflikkerd worden zolang het op elke plaats vervangen wordt door 'loggedIn'.
             * 
             * Ik heb enkel dit bestand en login.html aangepast.
             * Daar heb ik oa de 'ng-model'-naam veranderd en userName naar username gewijzigd.
             * 
             */
            
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
                        $rootScope.user.displayName = $scope.credentials.username;
                        $rootScope.loggedIn = true;
                        $location.path('/');
                    } else {
                        /* When failed, do this */
                        $rootScope.authenticated = false;
                    }
                    callback && callback($rootScope.authenticated);
                }, function() {
                    $rootScope.authenticated = false;
                    callback && callback(false);
                });
            };

            authenticate();

            //TODO Code die in mijn origineel security project stonden, geen idee of er nog iets bruikbaars tussenstaat.
            /* self.credentials = {};
            self.login = function() {
                authenticate(self.credentials, function(authenticated) {
                    if (authenticated) {
                        console.log("Login succeeded");
                        $location.href("#/");
                        self.error = false;
                        $rootScope.authenticated = true;
                    } else {
                        console.log("Login failed");
                        $location.href("#/login");
                        self.error = true;
                        $rootScope.authenticated = false;
                    }
                })
            }; */
            
            
            //TODO Arjen's oorspronkelijke code
            // var username = $scope.login.username;
            // var docentOrNot = username.substring(username.length-7, username.length+1);
            //
            // $rootScope.user.displayName = username;
            // $rootScope.loggedIn = true;
            //
            // if (docentOrNot == "@pxl.be")
            // 	location.href = "#/docent";
            // else
            // 	location.href = "#/student";


        };

        $scope.logout = function () {
            $http.post('logout', {}).finally(function() {
                $rootScope.user.displayName = '';
                $rootScope.authenticated = false;
                $rootScope.loggedIn = false;
                $location.href("#/");
            });
        }
    }]);
