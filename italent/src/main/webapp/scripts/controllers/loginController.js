/**
 * Created by arjen on 10/04/16.
 */
angular.module('iTalentApp')
    .controller('loginController', ['$scope', '$rootScope', function ($scope, $rootScope) {

        $scope.loginSubmit = function () {

            /* Do authentication check */

            /* When success, do this */
        	var userName = $scope.login.userName;
        	var docentOrNot = userName.substring(userName.length-7, userName.length+1);
        	
            $rootScope.user.displayName = userName;
            $rootScope.loggedIn = true;
            
            if (docentOrNot == "@pxl.be")
            	location.href = "#/docent";
            else
            	location.href = "#/student";

            /* When failed, do this */

        };

        $scope.logout = function () {
            $rootScope.user.displayName = '';
            $rootScope.loggedIn = false;
        }
    }]);
