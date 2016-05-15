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
            console.log('Error getting projects:');
            console.log(err);
        });
    	
    	projectService.listMySubscribed().then(function (projects) {
            $scope.mySubscribedProjects = projects;
        }, function (err) {
            console.log('Error getting mySubscribed projects:');
            console.log(err);
        });
    	
    	projectService.listMyLiked().then(function (projects) {
            $scope.myLikedProjects = projects;
        }, function (err) {
            console.log('Error getting myliked projects:');
            console.log(err);
        });
        
        $scope.editProject = function(id) {
            $location.path('/editProject/' + id);
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
            likeService.saveOrUpdate(project.id).then(function () {
                $scope.message = "Likes updated";
            }, function (err) {
                console.log('Error updating likes: ');
                console.log(err);
            })
        };

    }]);
