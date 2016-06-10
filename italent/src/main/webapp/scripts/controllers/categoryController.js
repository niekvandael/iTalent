/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('categoryController', ['$scope', '$routeParams', 'toastr', 'categoryService', '$translate', function ($scope, $routeParams, toastr, categoryService, $translate) {

        $scope.newCategory = {};

        $scope.addCategory = function () {
            categoryService.save($scope.newCategory).then(function () {
                getCategories();
                toastr.success($translate.instant('views.messages.success_create_category'), $translate.instant('views.messages.success'));
                $scope.newCategory.description = "";
            }, function (err) {
                toastr.error($translate.instant('views.messages.error_create_category'), $translate.instant('views.messages.fail'));
                console.log('Error saving category: ');
                console.log(err);
            })
        };

        $scope.deleteCategory = function (categoryId) {
            categoryService.deleteItem(categoryId).then(function (success) {
                if (success.data) {
                    toastr.success($translate.instant('views.messages.success_delete_category'), $translate.instant('views.messages.success'));
                } else {
                    toastr.error($translate.instant('views.messages.error_delete_category_already_in_use'), $translate.instant('views.messages.fail'));
                }
                getCategories();
            }, function (err) {
                toastr.error($translate.instant('views.messages.error_delete_category'), $translate.instant('views.messages.fail'));
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
