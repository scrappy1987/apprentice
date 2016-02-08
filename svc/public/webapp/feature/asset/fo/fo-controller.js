"use strict";
(function () {

    angular.module("app").controller("foController", ["functionalOrganisationRepository", FOCtrl]);

    function FOCtrl (functionalOrganisationRepository) {
        var vm = this;

        functionalOrganisationRepository.getFunctionalOrganisation().then(function (results) {
            vm.functionalOrgs = results;
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;

        });
    }

}());