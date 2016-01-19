"use strict";

(function () {

    angular.module('app')
        .controller("projectController",
        ["$log", ProjectCtrl]);

    function ProjectCtrl($log) {
        var vm = this;
        $log.debug("Instantiated projectController controller");
    }
}());