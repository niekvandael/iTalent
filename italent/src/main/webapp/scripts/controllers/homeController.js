/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('homeController', ['$scope', '$rootScope', '$location', 'projectService', 'likeService', 'subscriberStudentService', 'subscriberDocentService', 'categoryService', function ($scope, $rootScope, $location, projectService, likeService, subscriberStudentService, subscriberDocentService, categoryService) {
        categoryService.list().then(function (categories) {
            $scope.categories = categories;

            $scope.categoryFilterArray = [];
            for (var i = 0; i < categories.length; i++) {
            	$scope.categoryFilterArray.push({id: categories[i].id, description: categories[i].description, on: true});
			}
        }, function (err) {
            console.log('Error getting categories:');
            console.log(err);
        });
        
        projectService.listHome().then(function (projects) {
            $scope.projects = projects;
        }, function (err) {
            console.log('Error getting projects:');
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
            likeService.saveOrUpdate(project.id).then(function () {
                $scope.message = "Likes updated";
            }, function (err) {
                console.log('Error updating likes: ');
                console.log(err);
            })
        };
        
        $scope.showDetails = function(id) {
            $location.path('/projects/' + id);
        };
        
        $scope.saveSubscriberStudent = function(id, hours) {
            subscriberStudentService.save(id, hours).then(function() {
                $location.path('/home');
            }, function(err) {
                console.log('Error saving subscriberStudent.');
                console.log(err);
            })
        };
        
        $scope.saveSubscriberDocent = function(id, percentage) {
            subscriberDocentService.save(id, percentage).then(function() {
                $location.path('/home');
            }, function(err) {
                console.log('Error saving subscriberDocent.');
                console.log(err);
            })
        };

        $scope.categoryFilter = function(proj){
    	   for(var cat in $scope.categoryFilterArray){
               var t = $scope.categoryFilterArray[cat];
               if(t.on && proj.category.id === t.id){
                   return true;   
               }               
           }
        }
    }]);
