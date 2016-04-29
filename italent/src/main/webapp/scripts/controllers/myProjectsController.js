/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('myProjectsController', ['$scope', '$location', function ($scope, $location) {

        $scope.myProjects = 'My projects page';
       
        $scope.newProject = function() {
            $location.path('/newProject');
        };
    }]);
