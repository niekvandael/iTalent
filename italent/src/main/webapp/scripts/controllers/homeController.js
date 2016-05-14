/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('homeController', ['$scope', '$rootScope', '$location', 'projectService', 'likeService', 'subscriberStudentService', 'subscriberDocentService', function ($scope, $rootScope, $location, projectService, likeService, subscriberStudentService, subscriberDocentService) {
    	
        projectService.listHome().then(function (projects) {
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
        
        $scope.saveSubscriberStudent = function(id, hours) {
            subscriberStudentService.save(id, hours).then(function() {
                $location.path('/home');
            }, function(err) {
                console.log('Error saving subscriberStudent.')
            })
        };
        
        $scope.saveSubscriberDocent = function(id, percentage) {
            subscriberDocentService.save(id, percentage).then(function() {
                $location.path('/home');
            }, function(err) {
                console.log('Error saving subscriberDocent.')
            })
        };
        
    }]);
