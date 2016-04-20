(function(){
	// 1. Dependency op ngRoute toevoegen
	angular.module('iTalentWebApp', ['ngRoute'])
		.config(moduleConfig);
	
	// 2. Include dependencies
	moduleConfig.$inject = ['$routeProvider'];

	// 3. Routes configureren
	function moduleConfig($routeProvider){
		$routeProvider
		.when('/', {
			templateUrl: 'views/home.html',
			controller: 'homeController',
			controllerAs: 'homeCtrl'
		})		
		.when('/home', {
			templateUrl: 'views/home.html',
			controller: 'homeController',
			controllerAs: 'homeCtrl'
		})
		.when('/404',{
			templateUrl : 'views/404.html'
		})
		.otherwise({
			redirectTo: '/404'
		})
	}
})();