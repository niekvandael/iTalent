/**
 * Created by arjen on 05/04/16.
 */
(function () {
    angular.module('iTalentApp', ['ngRoute', 'ngResource', 'pascalprecht.translate', 'tmh.dynamicLocale', 'ngCookies'])
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
                .when('/docent', {
                    templateUrl: 'views/docent.html',
                    controller: 'docentController'
                })
                .when('/student', {
                    templateUrl: 'views/student.html',
                    controller: 'studentController'
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
                .when('/about', {
                    templateUrl: 'views/about.html'
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
})();
