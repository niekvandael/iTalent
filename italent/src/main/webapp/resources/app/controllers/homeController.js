(function () {
	'use strict';
	// 1. Definitie
	angular.module('iTalentWebApp')
		.controller('homeController', homeController);
		
	// 2. Dependencies injecteren
	homeController.$inject = ['$scope', 'loginFactory'];
	
	// 3. Implementatie v/d controller
	function homeController($scope, loginFactory){
			this.people = 
				[
					{"firstName" : "Niek"},
					{"firstName" : "Jesse"},
					{"firstName" : "Dennie"},
					{"firstName" : "Bart"},
					{"firstName" : "Arjen"}
				];
	}
	
})();