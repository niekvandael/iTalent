(function(){
	'use strict';
	
	angular.module('iTalentWebApp')
		.factory('loginFactory', loginFactory);
	
	loginFactory.$inject = ['$http', 'GLOBALS'];

	function loginFactory($http, GLOBALS){
		var factory = {};
		
		var cars = undefined;
		var vm = this;
		
		factory.login = function(){
			return true;
		}
		
		return factory;
	}
})();