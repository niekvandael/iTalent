angular.module('iTalentApp')
    .controller('detailController', ['$scope', '$routeParams', 'projectService', 'likeService', 'subscriberStudentService', 'subscriberDocentService', 
        function ($scope, $routeParams, projectService, likeService, subscriberStudentService, subscriberDocentService) {

        var projectId = $routeParams.id;

        projectService.get(projectId).then(function (project) {
            $scope.project = project;
        }, function (err) {
            console.log('Error getting project:');
            console.log(err);
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
            likeService.saveOrUpdate(project.projectId).then(function () {
                $scope.message = "Likes updated";
            }, function (err) {
                console.log('Error updating likes: ');
                console.log(err);
            })
        };

        $scope.saveSubscriberStudent = function(id, hours) {
            subscriberStudentService.save(id, hours).then(function() {
                console.log('Success saving subscriberStudent');
            }, function(err) {
                console.log('Error saving subscriberStudent.');
                console.log(err);
            })
        };

        $scope.saveSubscriberDocent = function(id, percentage) {
            subscriberDocentService.save(id, percentage).then(function() {
                console.log('Success saving subscriberDocent');
            }, function(err) {
                console.log('Error saving subscriberDocent.');
                console.log(err);
            })
        };

    }]);
