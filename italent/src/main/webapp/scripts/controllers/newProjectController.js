angular.module('iTalentApp')
    .controller('newProjectController', ['$scope', '$location', '$routeParams', 'toastr', 'projectService', 'departmentService', 'categoryService', 'domainService',
                                         function ($scope, $location, $routeParams, toastr, projectService, departmentService, categoryService, domainService) {

        var projectId = $routeParams.id;
        $scope.project = {
            'user': null,
            'movies': [],
            'pictures': [],
            'milestones': [],
            'wantedSubscribers': [],
            'prezis': [],
            'onlineFiles': []
        };
        $scope.departments = [];
        $scope.categories = [];
        $scope.domains = [];
    	$scope.allTags = [];

        $scope.maxLengthOfMovies = 100;
        $scope.maxLengthOfPictures = 100;
        $scope.maxLengthOfMilestones = 100;
        $scope.maxLengthOfWantedSubscribers = 100;
        $scope.maxLengthOfPrezis = 100;
        $scope.maxLengthOfOnlineFiles = 100;

        $scope.picturesConverted = true;
        
        
        $scope.durationModes = [{
            value: 'minuten',
            label: 'Minuten'
          }, {
            value: 'uren',
            label: 'Uren'
          }, {
            value: 'dagen',
            label: 'Dagen'
          }, {
            value: 'maanden',
            label: 'Maanden'
          }];   
        $scope.project.durationSelect = $scope.durationModes[2];
        
        
        
    	$scope.loadTags = function(){
    		return $scope.allTags;
    	};
    	
        if (projectId) {
            projectService.getForEdit(projectId).then(function (project) {
                $scope.project = project;
                $scope.setDurationMode();
            }, function (err) {
                console.log('Error getting project: ');
                console.log(err);
            });
        }
        
        $scope.setDurationMode = function () {
            if ($scope.project.duration % 2678400 == 0) {
            	$scope.project.duration = $scope.project.duration / 2678400;
            	$scope.project.durationSelect = $scope.durationModes[3]; //months
                return;
            }
            if ($scope.project.duration % 86400 == 0) {
            	$scope.project.duration = $scope.project.duration / 86400;
            	$scope.project.durationSelect = $scope.durationModes[2]; //days
                return;
            }
            if ($scope.project.duration % 3600 == 0) {
            	$scope.project.duration = $scope.project.duration / 3600;
            	$scope.project.durationSelect = $scope.durationModes[1]; //hours
                return;
            }
            $scope.project.durationSelect = $scope.durationModes[0]; //minutes
        };

        $scope.save = function () {
        	$scope.calculateDuration();
            projectService.saveOrUpdate($scope.project).then(function (project) {
                toastr.success('Project is opgeslagen', 'Succes!');
                $location.path('/projects/' + project.projectId);
            }, function (err) {
                toastr.error('Probleem bij opslaan project, probeer het nogmaals.', 'Fout!');
                console.log('Error saving project.');
                console.log(err);
            })
        };
        
        $scope.calculateDuration = function () {
            if ($scope.project.durationSelect == $scope.durationModes[3]) {
            	$scope.project.duration = $scope.project.duration * 2678400; //months
                return;
            }
            if ($scope.project.durationSelect == $scope.durationModes[2]) {
            	$scope.project.duration = $scope.project.duration * 86400; //days
                return;
            }
            if ($scope.project.durationSelect == $scope.durationModes[1]) {
            	$scope.project.duration = $scope.project.duration * 3600; //hours
                return;
            }
            // do nothing if minutes...
        };

        $scope.getDepartments = function () {
            departmentService.list().then(function (departments) {
                $scope.departments = departments;
            }, function (err) {
                console.log('Error getting departments');
                console.log(err);
            })
        };

        $scope.getCategories = function () {
            categoryService.list().then(function (categories) {
                $scope.categories = categories;

                $scope.tagsArray = [];
                for (var i = 0; i < categories.length; i++) {
                	var category = categories[i];
                	category.text = category.description;
                	$scope.allTags.push(category);
    			}
            }, function (err) {
                console.log('Error getting categories');
                console.log(err);
            })
        };
        
        $scope.getDomains = function () {
            domainService.list().then(function (domains) {
                $scope.domains = domains;
            }, function (err) {
                console.log('Error getting domains');
                console.log(err);
            })
        };

        $scope.deleteProject = function () {
            projectService.deleteProject(projectId).then(function () {
                toastr.success('Project is verwijderd.', 'Succes!');
                $location.path('/myProjects');
            }, function (err) {
                toastr.error('Probleem bij verwijderen project, probeer het nogmaals.', 'Fout!');
                console.log('Error deleting project.');
                console.log(err);
            })
        };

        $scope.removeMovie = function(movie) {
            $scope.project.movies = _.without($scope.project.movies, movie);
        };

        $scope.removePicture = function (picture) {
            $scope.project.pictures = _.without($scope.project.pictures, picture);
        };

        $scope.removeMilestone = function (milestone) {
            $scope.project.milestones = _.without($scope.project.milestones, milestone);
        };

        $scope.removeSubscriber = function (subscriber) {
            $scope.project.wantedSubscribers = _.without($scope.project.wantedSubscribers, subscriber);
        };
        
        $scope.removeSubscriberStudent = function (subscriber) {
            $scope.project.subscribersStudent = _.without($scope.project.subscribersStudent, subscriber);
        };
        
        $scope.removeSubscriberDocent = function (subscriber) {
            $scope.project.subscribersDocent = _.without($scope.project.subscribersDocent, subscriber);
        };

        $scope.removePrezi = function (prezi) {
            $scope.project.prezis = _.without($scope.project.prezis, prezi);
        };

        $scope.removeFile = function (file) {
            $scope.project.onlineFiles = _.without($scope.project.onlineFiles, file);
        };

        $scope.convertImage = function (element, i) {
            $scope.$apply(function () {

                $scope.picturesConverted = false;

                var reader = new FileReader();
                (function () {
                    reader.addEventListener("load", function () {
                        var index = parseInt(element.getAttribute("index"));
                        var resizedImage = $scope.resizeImage(reader.result, index);
                    }, false);
                })(i);

                reader.readAsDataURL(element.files[0]);
            });
        };

        $scope.resizeImage = function (imageBase64, index) {
            var image = new Image;

            image.onload = function () {
                $scope.resizeOnImageLoad(imageBase64, index)
            };
            image.src = imageBase64;
        };

        $scope.resizeOnImageLoad = function (image, index) {
            var width = 600;
            var quality = 0.9; // 0: low, 1: high

            // create an off-screen canvas
            var canvas = document.createElement('canvas');

            var ctx = canvas.getContext('2d');

            // draw source image into the off-screen canvas:
            var imgObj = new Image();
            imgObj.src = image;

            var height = imgObj.height / (imgObj.width / width);

            // set its dimension to target size
            canvas.width = width;
            canvas.height = height;

            ctx.drawImage(imgObj, 0, 0, width, height);

            // encode image to data-uri with base64 version of compressed image
            var smallerImage = canvas.toDataURL('image/jpeg', quality);
            imgObj.src = smallerImage;
            ctx.drawImage(imgObj, 0, 0, width, height);

            $scope.project.pictures[index].bytes = smallerImage.split(",")[1];
            $scope.picturesConverted = true;
        };

        $scope.cancel = function () {
        	if ($scope.project.projectId){
        		$location.path('/projects/' + $scope.project.projectId);
        	}
        	else{
        		$location.path('/myProjects');
        	}
            
        };

        $scope.addMovie = function () {
            if ($scope.project.movies.length == this.maxLengthOfMovies) {
                return;
            }
            $scope.project.movies.push({'youTubeCode': '', 'description': ''});
        };

        $scope.addPrezi = function () {
            if ($scope.project.prezis.length == this.maxLengthOfPrezis) {
                return;
            }
            $scope.project.prezis.push({'preziCode': '', 'description': ''});
        };

        $scope.addOnlineFile = function () {
            if ($scope.project.onlineFiles.length == this.maxLengthOfOnlineFiles) {
                return;
            }
            $scope.project.onlineFiles.push({'url': '', 'description': ''});
        };

        $scope.addWantedSubscriber = function () {
            if ($scope.project.wantedSubscribers.length == this.maxLengthOfWantedSubscribers) {
                return;
            }
            $scope.project.wantedSubscribers.push({'department': {id: 0}, 'number': 0});
        };

        $scope.addPicture = function () {
            if ($scope.project.pictures.length == this.maxLengthOfPictures) {
                return;
            }
            $scope.project.pictures.push({'bytes': '', 'description': ''});
        };

        $scope.addMilestone = function () {
            if ($scope.project.milestones.length == this.maxLengthOfMilestones) {
                return;
            }
            $scope.project.milestones.push({'description': ''});
        };
        
        $scope.getDepartments();
        $scope.getCategories();
        $scope.getDomains();
    }]);
