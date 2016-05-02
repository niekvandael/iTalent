/**
 * Created by arjen on 18/04/2016.
 */

angular.module('iTalentApp')
    .factory('projectService', ['$resource', '$q', '$http', 'GLOBALS', function ($resource, $q, $http, GLOBALS) {

        return {
            get: function (id) {
                var deferred = $q.defer();

                var resource = $resource(GLOBALS.baseURL + "projects/:id", {id: "@_id"});

                resource.get({id: id}, function (project) {
                    deferred.resolve(project);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },
            listPublic: function () {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "projects/public", {}, {list: {method: "GET", isArray: true}});

                resource.list(function (projectList) {
                    deferred.resolve(projectList);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },
            listDocent: function () {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "projects/docent", {}, {list: {method: "GET", isArray: true}});

                resource.list(function (projectList) {
                    deferred.resolve(projectList);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },
            listStudent: function () {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "projects/student", {}, {list: {method: "GET", isArray: true}});

                resource.list(function (projectList) {
                    deferred.resolve(projectList);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },
            listUser: function () {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "projects/user", {}, {list: {method: "GET", isArray: true}});

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
                //var resource = $resource(GLOBALS.baseURL + "projects/" + "/:id", {id: "@_id"}, {update: {method: "PUT"}});

                var resource = $resource(GLOBALS.baseURL + "projects/save", {}, {update: {method: "PUT"}});
                
                if (angular.isDefined(project.id)) {
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
