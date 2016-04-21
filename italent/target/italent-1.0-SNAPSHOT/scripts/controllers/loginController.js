/**
 * Created by arjen on 10/04/16.
 */
angular.module('iTalentApp')
    .controller('loginController', ['$scope', '$rootScope', function ($scope, $rootScope) {

        $scope.loginSubmit = function () {

            /* Do authentication check */

            /* When success, do this */
            $rootScope.user.displayName = $scope.login.userName;
            $rootScope.loggedIn = true;
            location.href = "#/home";

            /* When failed, do this */

        };

        $scope.logout = function () {
            $rootScope.user.displayName = '';
            $rootScope.loggedIn = false;
        }
    }]);
