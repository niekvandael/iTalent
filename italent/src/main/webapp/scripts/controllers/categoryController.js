/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('categoryController', ['$scope', '$routeParams', 'categoryService', function ($scope, $routeParams, categoryService) {

        $scope.newCategory = {};

        $scope.addCategory = function () {
            categoryService.save($scope.newCategory).then(function () {
                getCategories();
                $scope.message = "Category has been created!";
                $scope.newCategory.description = "";
            }, function (err) {
                $scope.message = "Category addition failed...";
                console.log('Error saving category: ');
                console.log(err);
            })
        };

        $scope.deleteCategory = function (categoryId) {
            categoryService.deleteItem(categoryId).then(function () {
                getCategories();
                $scope.message = "Category has been deleted!";
            }, function (err) {
                $scope.message = "Cannot delete item: some projects are depending on this category";
                console.log('Error deleting category: ');
                console.log(err);
            })
        };

        function getCategories() {
            categoryService.list().then(function (categories) {
                $scope.categories = categories;
            }, function (err) {
                console.log('Error getting categories: ' + err);
                console.log(err);
            });
        }

        getCategories();

    }]);
