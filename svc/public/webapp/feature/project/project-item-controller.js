"use strict";

(function () {

    angular.module('app')
        .controller("projectItemController",
        ["$log", ProjectItemCtrl]);

    function ProjectItemCtrl() {
        var vm = this;
        $log.debug("Instantiated projectItemController controller");
    }

}());