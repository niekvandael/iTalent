/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
     .controller('myProjectsController', ['$scope', '$rootScope', '$location', 'projectService', 'likeService', function ($scope, $rootScope, $location, projectService, likeService) {

    	$scope.myProjectsIsCollapsed = true;
    	$scope.subscribedProjectsIsCollapsed = true;
    	$scope.likedProjectsIsCollapsed = true;
    	$scope.myProjects = {};
    	 
    	projectService.listUser().then(function (projects) {
            $scope.myProjects = projects;
        }, function (err) {
            console.log('Error getting projects: ' + err)
        });
       
        $scope.newProject = function() {
            $location.path('/newProject');
        };
        
        $scope.showDetails = function(id) {
            $location.path('/projects/' + id);
        };
        
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
    }]);
