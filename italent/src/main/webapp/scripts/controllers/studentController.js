angular.module('iTalentApp')
    .controller('studentController', ['$scope', '$rootScope', '$location', 'subscriberStudentService', 'projectService', 'likeService', 
                                      function ($scope, $rootScope, $location, subscriberStudentService, projectService, likeService) {

    	$scope.subscriberStudent = {'user': null, 'project': null};
    	
        projectService.listStudent().then(function (projects) {
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
        
        $scope.save = function(id, hours) {
            subscriberStudentService.save(id, hours).then(function() {
                $location.path('/student');
            }, function(err) {
                console.log('Error saving subscriber.')
            })
        };
        
    }]);
