angular.module('iTalentApp')
    .controller('docentController', ['$scope', '$rootScope', '$location', 'projectService', 'likeService', function ($scope, $rootScope, $location, projectService, likeService) {

        projectService.listDocent().then(function (projects) {
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
