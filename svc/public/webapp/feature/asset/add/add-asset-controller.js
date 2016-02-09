"use strict";
(function () {

    angular.module("app").controller("addAssetController", ["functionalOrganisationRepository", "locationRepository", AddAssetCtrl]);

    function AddAssetCtrl (functionalOrganisationRepository, locationRepository) {
        var vm = this;

        /*
         * Functional Organisations
         */
        functionalOrganisationRepository.getFunctionalOrganisation().then(function (results) {
            vm.functionalOrgs = results;
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });

        /*
         * Locations
         */
        vm.getLocations = function(id) {

            console.log(id);

            locationRepository.getLocation(id).then(function (results) {
                vm.locations = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
    }

}());