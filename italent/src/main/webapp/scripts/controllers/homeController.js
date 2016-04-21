/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('homeController', ['$scope', '$rootScope', 'projectService', function ($scope, $rootScope, projectService) {

        $scope.homeTest = 'Test page home';
        
        $scope.projects = projectService.list();
       
    }]);
