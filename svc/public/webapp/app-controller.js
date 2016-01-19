"use strict";

(function () {

    angular
        .module('app')
        .controller("appController",
        ["$log", AppCtrl]);


    function AppCtrl($log) {
        var vm = this;
        $log.debug("Application Instantiated");
    }

}());