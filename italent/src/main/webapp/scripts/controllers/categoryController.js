/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('categoryController', ['$scope', '$routeParams', 'categoryService', function ($scope, $routeParams, categoryService) {
    	
    	$scope.newCategory = {};

    	$scope.getCategories = function(){
        	categoryService.list().then(function (categories) {
                $scope.categories = categories;
            }, function (err) {
                console.log('Error getting project: ' + err)
            });    		
    	}
        $scope.addCategory = function () {
        	categoryService.saveOrUpdate(this.newCategory).then(function (success) {
        		if(success.id == 0){
        			$scope.message = "Category addition failed...";
        		} else {
        			$scope.getCategories();
        			$scope.message = "Category has been created!";
        			$scope.newCategory.description = "";
        		}
            });
        };
     
        $scope.deleteCategory = function (categoryId) {
        	categoryService.deleteItem(categoryId).then(function (success) {
        		if(!success.data){
        			$scope.message = "Cannot delete item: some projects are depending on this category";
        		} else {
        			$scope.getCategories();
        			$scope.message = "Deletion successfull";
        		}
            });
        };

    	
    	$scope.getCategories();
    	
    }]);
