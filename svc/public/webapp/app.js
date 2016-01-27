"use strict";
(function () {

    var app = angular.module("app", ["ui.router", 'ngMessages']).run(
        function ($window, $rootScope, $log) {
            $log.debug("Application Instantiated");
        });

}());
