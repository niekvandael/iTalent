angular.module('iTalentApp')
    .factory('commentService', ['$resource', '$q', '$http', 'GLOBALS', function ($resource, $q, $http, GLOBALS) {

        return {
            list: function (projectId) {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "comments/" + projectId, {}, {list: {method: "GET", isArray: true}});

                resource.list(function (projectList) {
                    deferred.resolve(projectList);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },

            save: function (projectId, comment) {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "comments/save/" + projectId, {update: {method: "POST"}});

                resource.save(comment, function () {
                    deferred.resolve();
                }, function (err) {
                    deferred.reject(err);
                });
                
                return deferred.promise;
            },
        }
    }]);
