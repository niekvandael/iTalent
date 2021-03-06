/**
 * Created by arjen on 05/04/16.
 */
(function () {
    angular.module('iTalentApp', ['ngRoute', 'ngResource', 'pascalprecht.translate', 'tmh.dynamicLocale', 'ngCookies', 'ui.bootstrap', 'ngTagsInput', '720kb.socialshare', 'toastr', 'ngAnimate'])
        .run(['$rootScope', '$http', 'userService', function ($rootScope, $http, userService) {
        	userService.refresh();
        }])
        
        .filter('youtubeEmbedUrl', function ($sce) {
		    return function(videoId) {
		      return $sce.trustAsResourceUrl('https://www.youtube.com/embed/' + videoId);
		    };
		})
        .config(function ($routeProvider) {
            $routeProvider
                .when('/home', {
                    templateUrl: 'views/home.html',
                    controller: 'homeController'
                })
                .when('/projects/:id', {
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
                .when('/newProject', {
                    templateUrl: 'views/newProject.html',
                    controller: 'newProjectController'
                })
                .when('/editProject/:id', {
                    templateUrl: 'views/newProject.html',
                    controller: 'newProjectController'
                })
                .when('/archive', {
                    templateUrl: 'views/home.html',
                    controller: 'homeController'
                })
                .when('/about', {
                    templateUrl: 'views/about.html'
                })
                .when('/category', {
                        templateUrl: 'views/category.html',
                        controller: 'categoryController'
                })
                .otherwise({
                    redirectTo: '/home'
                })
        })
        .config(function ($translateProvider) {
            $translateProvider.useStaticFilesLoader({
                prefix: 'resources/locale-',// path to translations files
                suffix: '.json'// suffix, currently- extension of the translations
            });
            $translateProvider.preferredLanguage('nl_NL');// is applied on first load
            $translateProvider.useLocalStorage();// saves selected language to localStorage
        })
        .config(function ($translateProvider) {
            $translateProvider.useMissingTranslationHandlerLog();
        })
        .config(function (tmhDynamicLocaleProvider) {
            tmhDynamicLocaleProvider.localeLocationPattern('bower_components/angular-i18n/angular-locale_{{locale}}.js');
        })
        .config(['$httpProvider',
        function ($httpProvider) {
            $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
        }
    ]);
})();