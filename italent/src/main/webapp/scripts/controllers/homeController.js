angular.module('iTalentApp')
    .controller('homeController', ['$scope', '$rootScope', '$location', 'projectService', 'likeService', 'categoryService', 
        function ($scope, $rootScope, $location, projectService, likeService, categoryService) {
       
    	$scope.tags = [];
    	$scope.allTags = [];
    	
    	$scope.loadTags = function(){
    		return $scope.allTags;
    	}
    	categoryService.list().then(function (categories) {
            $scope.categories = categories;

            $scope.categoryFilterArray = [];
            $scope.tagsArray = [];
            for (var i = 0; i < categories.length; i++) {
            	$scope.categoryFilterArray.push({id: categories[i].categoryId, description: categories[i].description, on: true});
            	$scope.allTags.push({text: categories[i].description, categoryId: categories[i].categoryId});
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
            
            likeService.saveOrUpdate(project.projectId).then(function () {
                $scope.message = "Likes updated";
            }, function (err) {
                console.log('Error updating likes: ');
                console.log(err);
            })
        };
        
        $scope.showDetails = function(id) {
            $location.path('/projects/' + id);
        };

        $scope.nonBackedFilter = function(proj){
        	if($scope.showOnlyNonBacked){
        		if(proj.backingPct < 100){
        			return true;	
        		} else {
        			return false;
        		}
        	}
        	return true;
        }
        
        $scope.tagFilter = function(proj){
        	if($scope.tags.length == 0){
        		return true;
        	}
        	
        	for (var i = 0; i < $scope.tags.length; i++) {
        		var tag = $scope.tags[i];
        		
        		if(tag.categoryId === undefined){
        			// non-existing tag
        			return true;
        		}
        		
        		for (var j = 0; j < proj.categories.length; j++) {
					var projectTag = proj.categories[j];
	        		
	                if(projectTag.categoryId === tag.categoryId){
	                   return true;
	                }    
				}
 				
			}
        }
    }]);
