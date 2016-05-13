/**
 * Created by niek on 13/05/2016.
 */

angular.module('iTalentApp')
    .factory('departmentService', ['$resource', '$q', '$http', 'GLOBALS', function ($resource, $q, $http, GLOBALS) {

        return {
            get: function (id) {
                var deferred = $q.defer();

                var resource = $resource(GLOBALS.baseURL + "departments/:id", {id: "@_id"});

                resource.get({id: id}, function (Department) {
                    deferred.resolve(Department);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },
            list: function () {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "departments", {}, {list: {method: "GET", isArray: true}});

                resource.list(function (departmentList) {
                    deferred.resolve(departmentList);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },

            save: function (department) {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "departments");

                resource.save(department, function (savedDepartment) {
                    deferred.resolve(savedDepartment);
                }, function (err) {
                    deferred.reject(err);
                });
                
                return deferred.promise;
            },

            deleteItem: function (departmentId) {
                return $http({
                    url: GLOBALS.baseURL + 'departments/delete/' + departmentId,
                    method: "DELETE"
                });
            }
        }
    }]);
