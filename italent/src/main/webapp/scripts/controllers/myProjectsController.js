/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
     .controller('myProjectsController', ['$scope', '$rootScope', '$location', 'projectService', 'likeService', function ($scope, $rootScope, $location, projectService, likeService) {

    	projectService.listUser().then(function (projects) {
            $scope.projects = projects;
        }, function (err) {
            console.log('Error getting projects: ' + err)
        });
       
        $scope.newProject = function() {
            $location.path('/newProject');
        };
    }]);
