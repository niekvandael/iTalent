/**
 * Created by arjen on 24/04/2016.
 */

angular.module('iTalentApp')
    .directive('ngTranslateLanguageSelect', function (localeService) {
        'use strict';

    return {
        restrict: 'A',
        replace: true,
        template: ''+
        '<div class="language-select" ng-if="visible">'+
        '<label>'+
        '{{"directives.language-select.Language" | translate}}:'+
        '<select class="form-control" ng-model="currentLocaleDisplayName"'+
        'ng-options="localesDisplayName for localesDisplayName in localesDisplayNames"'+
        'ng-change="changeLanguage(currentLocaleDisplayName)">'+
        '</select>'+
        '</label>'+
        '</div>'+
        '',
        controller: function ($scope) {
            $scope.currentLocaleDisplayName = localeService.getLocaleDisplayName();
            $scope.localesDisplayNames = localeService.getLocalesDisplayNames();
            $scope.visible = $scope.localesDisplayNames &&
                $scope.localesDisplayNames.length > 1;

            $scope.changeLanguage = function (locale) {
                localeService.setLocaleByDisplayName(locale);
            };
        }
    };
});
