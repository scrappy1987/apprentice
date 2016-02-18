"use strict";
(function () {

    angular.module("app").controller("assetOSPController", ["functionalOrganisationRepository", "locationRepository", "contactRepository", AssetOSPCtrl]);

    function AssetOSPCtrl (functionalOrganisationRepository, locationRepository, contactRepository) {
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
            vm.currentFunctionalOrgId = id;
            locationRepository.getLocation(id).then(function (results) {
                vm.locations = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
         /*
         * Contact
         */
        vm.getContacts = function(id) {

            console.log(id);
            contactRepository.getContact(id).then(function (results) {
                vm.contacts = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
    }

}());