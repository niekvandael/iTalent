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
    	
    	projectService.listMySubscribed().then(function (projects) {
            $scope.mySubscribedProjects = projects;
        }, function (err) {
            console.log('Error getting mySubscribed projects: ' + err)
        });
    	
    	projectService.listMyLiked().then(function (projects) {
            $scope.myLikedProjects = projects;
        }, function (err) {
            console.log('Error getting myliked projects: ' + err)
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
