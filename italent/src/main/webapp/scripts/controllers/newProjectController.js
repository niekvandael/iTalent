/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('newProjectController', ['$scope', '$location', 'projectService', function ($scope, $location, projectService) {

        $scope.project = {'user': null, 'movies' : []};
        $scope.maxLengthOfMovies = 5;
        
        $scope.save = function() {
        	$scope.storeMovies();
            projectService.saveOrUpdate($scope.project).then(function() {
                $location.path('/myProjects');
            }, function(err) {
                console.log('Error saving project.')
            })
        };

        $scope.storeMovies = function(){
        	for (var i = 0; i < $scope.maxLengthOfMovies; i++) {
				var element = document.getElementById("project_movie_" + i);
				if(element == null){
					break;
				}
				$scope.project.movies[i].youTubeId = element.value;
			}
        };
        
        $scope.cancel = function() {
            $location.path('/myProjects');
        };
        
        $scope.addMovie = function(){
        	if($scope.project.movies.length == this.maxLengthOfMovies){
        		return;
        	}
            $scope.project.movies.push({'youTubeId':'', description:''})
        }
        
        $scope.addMovie();
    }]);
