/**
 * Created by arjen on 05/04/16.
 */
angular.module('iTalentApp')
    .controller('categoryController', ['$scope', '$routeParams', 'toastr', 'categoryService', function ($scope, $routeParams, toastr, categoryService) {

        $scope.newCategory = {};

        $scope.addCategory = function () {
            categoryService.save($scope.newCategory).then(function () {
                getCategories();
                toastr.success('Categorie is aangemaakt', 'Succes!');
                $scope.newCategory.description = "";
            }, function (err) {
                toastr.error('Probleem bij aanmaken categorie, probeer het nogmaals.', 'Fout!');
                console.log('Error saving category: ');
                console.log(err);
            })
        };

        $scope.deleteCategory = function (categoryId) {
            categoryService.deleteItem(categoryId).then(function (success) {
                if (success.data) {
                    toastr.success('Categorie is verwijderd.', 'Succes!');
                } else {
                    toastr.error('Kan categorie niet verwijderen aangezien deze nog in gebruik is.', 'Fout!');
                }
                getCategories();
            }, function (err) {
                toastr.error('Probleem bij verwijderen categorie, probeer het nogmaals.', 'Fout!');
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
