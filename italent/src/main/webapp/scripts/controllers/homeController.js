/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('homeController', ['$scope', '$rootScope', '$location', 'projectService', 'likeService', function ($scope, $rootScope, $location, projectService, likeService) {

        projectService.list().then(function (projects) {
            $scope.projects = projects;
        }, function (err) {
            console.log('Error getting projects: ' + err)
        });
        
        $scope.likeClicked = function (project) {
            if (!project.numberOfLikes) {
                project.numberOfLikes = 0;
            }
            if (project.liked) {
                project.numberOfLikes--;
            } else {
                project.numberOfLikes++;
            }
            project.liked = !project.liked;
            likeService.saveOrUpdate(project.id);
        };
        
        $scope.showDetails = function(id) {
            $location.path('/projects/' + id);
        };
        
    }]);
