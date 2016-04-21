(function(){
	'use strict';
	
	angular.module('iTalentWebApp')
		.factory('categoryFactory', categoryFactory);
	
	categoryFactory.$inject = ['$http', 'GLOBALS'];

	function categoryFactory($http, GLOBALS){
		var factory = {};
		
		var categories = undefined;
		var vm = this;
		
		factory.getCategories = function(){
			return $http({
				method: 'GET',
				url: GLOBALS.baseURL + "categories"
			})
		}
		
		return factory;
	}
})();