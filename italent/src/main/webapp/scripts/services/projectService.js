/**
 * Created by arjen on 18/04/2016.
 */

angular.module('iTalentApp')
    .factory('projectService', ['$resource', '$q', '$http', function ($resource, $q, $http) {

        return {
            get: function (id) {
                var deferred = $q.defer();

                var resource = $resource("......./projects" + "/:id", {id: "@_id"});

                resource.get({id: id}, function (project) {
                    deferred.resolve(project);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },
            list: function () {
                var deferred = $q.defer();

                var resource = $resource("http://italent-itproject.rhcloud.com/ws/categories", {}, {list: {method: "GET", isArray: true}});

                resource.list(function (projectList) {
                    deferred.resolve(projectList);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },
            saveOrUpdate: function (project) {
                project = angular.copy(project);
                var deferred = $q.defer();
                var resource = $resource("......../project" + "/:id", {id: "@_id"}, {update: {method: "PUT"}});

                if (angular.isDefined(project._id)) {
                    resource.update(project, function (updatedProject) {
                        deferred.resolve(updatedProject);
                    }, function (err) {
                        deferred.reject(err);
                    });
                }
                else {
                    resource.save(project, function (savedProject) {
                        deferred.resolve(savedProject);
                    }, function (err) {
                        deferred.reject(err);
                    });
                }
                return deferred.promise;
            }
        }
    }]);
