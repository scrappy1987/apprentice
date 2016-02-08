"use strict";
(function () {

    var app = angular.module("app", ["ui.router", 'ngMessages', 'toastr' ]).run(
        function ($window, $rootScope, $log) {
            $log.debug("Application Instantiated");
        });

}());
