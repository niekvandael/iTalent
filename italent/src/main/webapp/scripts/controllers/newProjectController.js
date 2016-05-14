/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('newProjectController', ['$scope', '$location', '$routeParams', 'projectService', 'departmentService', function ($scope, $location, $routeParams, projectService, departmentService) {

        var projectId = $routeParams.id;
        $scope.project = {'user': null, 'movies' : [], 'pictures' : [], 'milestones': [], 'wantedSubscribers': [], 'prezis': [], 'onlineFiles': []};
        $scope.departments = [];
       
        $scope.maxLengthOfMovies = 5;
        $scope.maxLengthOfPictures = 10;
        $scope.maxLengthOfMilestones = 10;
        $scope.maxLengthOfWantedSubscribers = 10;
        $scope.maxLengthOfPrezis = 10;
        $scope.maxLengthOfOnlineFiles = 10;
        
        $scope.picturesConverted = true;
        
        if (projectId) {
            projectService.get(projectId).then(function (project) {
                $scope.project = project;
            }, function (err) {
                console.log('Error getting project: ' + err)
            });
        }
        
        $scope.save = function() {
        	$scope.storeMovies();
        	$scope.storePictures();
        	$scope.storeMilestones();
        	$scope.storeWantedSubscribers();
        	$scope.storePrezis();
        	$scope.storeOnlineFiles();
        	
            projectService.saveOrUpdate($scope.project).then(function() {
                $location.path('/myProjects');
            }, function(err) {
                console.log('Error saving project.')
            })
        };
        
        $scope.getDepartments = function() {
            departmentService.list().then(function(departments) {
            	$scope.departments = departments;
            }, function(err) {
                console.log('Error getting departments')
            })
        };
        
        $scope.deleteProject = function() {   
            projectService.deleteProject(projectId).then(function() {
                $location.path('/myProjects');
            }, function(err) {
                console.log('Error deleting project.')
            })
        };

        $scope.storeMovies = function(){
        	for (var i = 0; i < $scope.maxLengthOfMovies; i++) {
				var element = document.getElementById("project_movie_" + i);
				var element_descr = document.getElementById("project_movie_descr_" + i);
				if(element_descr == null){
					break;
				}

				$scope.project.movies[i].youTubeId = element.value;
				$scope.project.movies[i].description = element_descr.value;
			}
        };
        
        $scope.storePrezis = function(){
        	for (var i = 0; i < $scope.maxLengthOfPrezis; i++) {
				var element = document.getElementById("project_prezi_" + i);
				var element_descr = document.getElementById("project_prezi_descr_" + i);
				if(element_descr == null){
					break;
				}

				$scope.project.prezis[i].preziId = element.value;
				$scope.project.prezis[i].description = element_descr.value;
			}
        };
        
        $scope.storeOnlineFiles = function(){
        	for (var i = 0; i < $scope.maxLengthOfOnlineFiles; i++) {
				var element = document.getElementById("project_onlineFile_" + i);
				var element_descr = document.getElementById("project_onlineFile_descr_" + i);
				if(element_descr == null){
					break;
				}

				$scope.project.onlineFiles[i].url = element.value;
				$scope.project.onlineFiles[i].description = element_descr.value;
			}
        };
        
        $scope.storePictures = function(){
        	for (var i = 0; i < $scope.maxLengthOfPictures; i++) {
				var element_descr = document.getElementById("project_picture_descr_" + i);
				if(element_descr == null){
					break;
				}
				
				$scope.project.pictures[i].description = element_descr.value;
			}
        };
        $scope.storeMilestones = function(){
        	for (var i = 0; i < $scope.maxLengthOfMilestones; i++) {
				var element = document.getElementById("project_milestone_" + i);
				if(element == null){
					break;
				}
				
				$scope.project.milestones[i].description = element.value;
			}
        };
        $scope.storeWantedSubscribers = function(){
        	for (var i = 0; i < $scope.maxLengthOfMilestones; i++) {
				var departmentInput = document.getElementById("project_wantedSubscriber_department_" + i);
				var numberInput = document.getElementById("project_wantedSubscriber_number_" + i);
				
				if(departmentInput == null || numberInput == null){
					break;
				}
				
				$scope.project.wantedSubscribers[i].number = numberInput.value;
				$scope.project.wantedSubscribers[i].department.id = departmentInput.value;
			}
        };
        $scope.convertImage = function(element, i) {
            $scope.$apply(function(scope) {
            	
            	$scope.picturesConverted = false;
            	
            	var reader  = new FileReader();
    	        (function (i) {
                	reader.addEventListener("load", function () {
                		var index = parseInt(element.getAttribute("index"));
                		$scope.project.pictures[index].bytes = reader.result.split(",")[1];
                		$scope.picturesConverted = true;		
    				}, false);
    		         })(i);
    			
    			reader.readAsDataURL(element.files[0]);
            });
       };
        
        $scope.cancel = function() {
            $location.path('/myProjects');
        };
        
        $scope.addMovie = function(){
        	if($scope.project.movies.length == this.maxLengthOfMovies){
        		return;
        	}
            $scope.project.movies.push({'youTubeId':'', 'description':''});
        };
        
        $scope.addPrezi = function(){
        	if($scope.project.prezis.length == this.maxLengthOfPrezis){
        		return;
        	}
            $scope.project.prezis.push({'preziId':'', 'description':''});
        };
        
        $scope.addOnlineFile = function(){
        	if($scope.project.onlineFiles.length == this.maxLengthOfOnlineFiles){
        		return;
        	}
            $scope.project.onlineFiles.push({'url':'', 'description':''});
        };
        
        $scope.addWantedSubscriber = function(){
        	if($scope.project.wantedSubscribers.length == this.maxLengthOfWantedSubscribers){
        		return;
        	}
            $scope.project.wantedSubscribers.push({'department':{id:0}, 'number':0});
        }
        
        $scope.addPicture = function(){
        	if($scope.project.pictures.length == this.maxLengthOfPictures){
        		return;
        	}
            $scope.project.pictures.push({'bytes':'', 'description':''});
        };
        
        $scope.addMilestone = function(){
        	if($scope.project.milestones.length == this.maxLengthOfMilestones){
        		return;
        	}
            $scope.project.milestones.push({'description':''});
        };
        
        $scope.getDepartments();
    }]);
