/**
 * Created by arjen on 18/04/2016.
 */

angular.module('iTalentApp')
    .factory('categoryService', ['$resource', '$q', '$http', 'GLOBALS', function ($resource, $q, $http, GLOBALS) {

        return {
            get: function (id) {
                var deferred = $q.defer();

                var resource = $resource(GLOBALS.baseURL + "categories/:id", {id: "@_id"});

                resource.get({id: id}, function (Category) {
                    deferred.resolve(Category);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },
            list: function () {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "categories", {}, {list: {method: "GET", isArray: true}});

                resource.list(function (CategoryList) {
                    deferred.resolve(CategoryList);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },
           
            
            saveOrUpdate: function (category) {
            	category = angular.copy(category);
                var deferred = $q.defer();

                var resource = $resource(GLOBALS.baseURL + "categories", {}, {update: {method: "PUT"}});
                
                if (angular.isDefined(category.id)) {
                    resource.update(category, function (updatedCategory) {
                        deferred.resolve(updatedCategory);
                    }, function (err) {
                        deferred.reject(err);
                    });
                }
                else {
                    resource.save(category, function (savedCategory) {
                        deferred.resolve(savedCategory);
                    }, function (err) {
                        deferred.reject(err);
                    });
                }
                return deferred.promise;
            },
            
            deleteItem: function (categoryId) {
              	   return $http({
              	        url: GLOBALS.baseURL + 'categories/delete/' + categoryId,
              	        method: "DELETE"
              	    })
                
                return deferred.promise;
            }
        }
    }]);
