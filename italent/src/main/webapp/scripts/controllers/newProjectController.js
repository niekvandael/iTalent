/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('newProjectController', ['$scope', '$location', 'projectService', function ($scope, $location, projectService) {

        $scope.project = {};

        $scope.save = function() {
            projectService.saveOrUpdate($scope.project).then(function() {
                $location.path('/myProjects');
            }, function(err) {
                console.log('Error saving project.')
            })
        };

        $scope.cancel = function() {
            $location.path('/myProjects');
        };
        
    }]);
