/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('detailController', ['$scope', '$routeParams', 'projectService', function ($scope, $routeParams, projectService) {

        $scope.projectDetail = 'Project detail page.';

        var projectId = $routeParams.id;
        $scope.project = projectService.get(projectId);
       
    }]);
