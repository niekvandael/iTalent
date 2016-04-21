(function () {
	'use strict';
	// 1. Definitie
	angular.module('iTalentWebApp')
		.controller('homeController', homeController);
		
	// 2. Dependencies injecteren
	homeController.$inject = ['$scope', 'categoryFactory'];
	
	// 3. Implementatie v/d controller
	function homeController($scope, categoryFactory){
		categoryFactory.getCategories()
		.success(function(categories){
			vm.categories = categories;
		})
		.error(function(err, status){
			vm.errorMsg=err;
			vm.status=status;
		});
	}
	
})();