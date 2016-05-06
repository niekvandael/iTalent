/**
 * Created by Jesse on 5/05/2016.
 */

angular.module('iTalentApp')
    .factory('subscriberStudentService', ['$resource', '$q', '$http', 'GLOBALS', function ($resource, $q, $http, GLOBALS) {
        return {
            save: function (id, hours) {
            	   return $http({
            	        url: GLOBALS.baseURL + 'subscriberStudent/save/' + id + '/' + hours,
            	        method: "POST"
            	    })
            }
        }
    }]);


/*angular.module('iTalentApp')
    .factory('subscriberStudentService', ['$resource', '$q', '$http', 'GLOBALS', function ($resource, $q, $http, GLOBALS) {

        return {
            save: function (subscriberStudent) {
                subscriberS = angular.copy(subscriberStudent);
                var deferred = $q.defer();
                //var resource = $resource(GLOBALS.baseURL + "projects/" + "/:id", {id: "@_id"}, {update: {method: "PUT"}});

                var resource = $resource(GLOBALS.baseURL + "subscriberStudent/save", {}, {update: {method: "PUT"}});
                
                /*if (angular.isDefined(project.id)) {
                    resource.update(project, function (updatedProject) {
                        deferred.resolve(updatedProject);
                    }, function (err) {
                        deferred.reject(err);
                    });
                }
                else {*/
                    
                	/*resource.save(subscriberStudent, function (savedSubscriberStudent) {
                        deferred.resolve(savedSubscriberStudent);
                    }, function (err) {
                        deferred.reject(err);
                    });
                	
                //}
                return deferred.promise;
            }
        }
    }]);*/
