"use strict";
(function () {

    angular.module("app").controller("manageAssetController", ["functionalOrganisationRepository", "locationRepository", "contactRepository", ManageAssetCtrl]);

    function ManageAssetCtrl (functionalOrganisationRepository, locationRepository, contactRepository, assetRepository) {
        var vm = this;

        functionalOrganisationRepository.getFunctionalOrganisation().then(function (results) {
            vm.functionalOrgs = results;
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });

        vm.getLocations = function(id) {
            console.log(id);

            locationRepository.getLocation(id).then(function (results) {
                vm.locations = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }


        vm.getContacts = function(id) {
            if (id === undefined){
                return;
            }
            console.log(id);
            contactRepository.getContact(id).then(function (results) {
                vm.contacts = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }

       vm.postAssets = function(id) {

            console.log(id);
            }

        /** Too add functionality for sending search results to bottom box**/
    }

}());