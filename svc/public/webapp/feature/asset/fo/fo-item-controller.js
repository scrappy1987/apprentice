"use strict";

(function () {

    angular.module('app').controller("foItemController", ["$state", "functionalOrganisationRepository", FOItemCtrl]);

    function FOItemCtrl($state, functionalOrganisationRepository) {
        var vm = this;
        // name constant - for trace and debugging
        vm.controllerName = "foItemController";

    }

}());
