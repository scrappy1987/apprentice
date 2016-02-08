"use strict";

(function () {

    angular.module('app').controller("foFormController", ["$log", "functionalOrganisationRepository", "$state", FOFormCtrl]);

    function FOFormCtrl($log, functionalOrganisationRepository, $state) {
        var vm = this;

        vm.hasValidationError = false;
        vm.functionalOrg = {};

    }
}());
