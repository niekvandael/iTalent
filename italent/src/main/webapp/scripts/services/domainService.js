angular.module('iTalentApp')
    .factory('domainService', ['$resource', '$q', '$http', 'GLOBALS', function ($resource, $q, $http, GLOBALS) {

        return {
            get: function (id) {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "domains/:id", {id: "@_id"});

                resource.get({id: id}, function (domain) {
                    deferred.resolve(domain);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },

            list: function () {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "domains", {}, {list: {method: "GET", isArray: true}});

                resource.list(function (domainList) {
                    deferred.resolve(domainList);
                }, function (err) {
                    deferred.reject(err);
                });

                return deferred.promise;
            },

            save: function (domain) {
                var deferred = $q.defer();
                var resource = $resource(GLOBALS.baseURL + "domains");

                resource.save(domain, function (savedDomain) {
                    deferred.resolve(savedDomain);
                }, function (err) {
                    deferred.reject(err);
                });
                
                return deferred.promise;
            },

            deleteItem: function (domainId) {
                return $http({
                    url: GLOBALS.baseURL + 'domains/delete/' + categoryId,
                    method: "DELETE"
                });
            }
        }
    }]);
