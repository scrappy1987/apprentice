"use strict";

(function () {

    angular.module('app')
        .controller("projectFormController",
        ["$log", ProjectFormCtrl]);

    function ProjectFormCtrl($log) {
        var vm = this;
        $log.debug("Instantiated projectFormController controller");
    }
}());