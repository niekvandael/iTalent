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
                console.log('Error saving category: ' + err)
            })
        };

        $scope.deleteCategory = function (categoryId) {
            categoryService.deleteItem(categoryId).then(function (success) {
                if (!success.data) {
                    $scope.message = "Cannot delete item: some projects are depending on this category";
                } else {
                    getCategories();
                    $scope.message = "Deletion successfull";
                }
            });
        };

        function getCategories() {
            categoryService.list().then(function (categories) {
                $scope.categories = categories;
            }, function (err) {
                console.log('Error getting categories: ' + err)
            });
        }

        getCategories();

    }]);
