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
            listHome: function () {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "projects/listHome", {}, {list: {method: "GET", isArray: true}});

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
            
            listMyLiked: function () {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "projects/myLiked", {}, {list: {method: "GET", isArray: true}});

                resource.list(function (projectList) {
                    deferred.resolve(projectList);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },
            
            listMySubscribed: function () {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "projects/mySubscribed", {}, {list: {method: "GET", isArray: true}});

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
                var resource = $resource(GLOBALS.baseURL + "projects/save/:id", {id: "@id"}, {update: {method: "PUT"}});
                
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
            },
            
            //TODO laten nakijken door Arjen (i have no clue what i'm doing ma het werkt ongeveer)
            deleteProject: function (id) {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "projects/delete/:id", {id: "@id"}, {update: {method: "POST"}});
                
                resource.update({id: id}, function (project) {
                    deferred.resolve(project);
                }, function (err) {
                    deferred.reject(err);
                });
                return deferred.promise;
            }
        }
    }]);
