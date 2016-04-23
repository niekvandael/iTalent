/**
 * Created by arjen on 05/04/16.
 */
(function () {
    angular.module('iTalentApp', ['ngRoute', 'ngResource'])
        .run(function ($rootScope) {
            $rootScope.user = {
                base64: '',
                displayName: ''
            };
            $rootScope.showNavBar = '';
        })
        .config(function ($routeProvider) {
            $routeProvider
                .when('/home', {
                    templateUrl: 'views/home.html',
                    controller: 'homeController'
                })
                .when('/detail/:id', {
                    templateUrl: 'views/detail.html',
                    controller: 'detailController'
                })
                .when('/login', {
                    templateUrl: 'views/login.html',
                    controller: 'loginController'
                })
                .when('/myProjects', {
                    templateUrl: 'views/myProjects.html',
                    controller: 'myProjectsController'
                })
                .when('/about', {
                    templateUrl: 'views/about.html'
                })
                .otherwise({
                    redirectTo: '/home'
                })
        })
})();
