"use strict";
(function () {

    angular.module("app").controller("locationController", ["locationRepository", LocationCtrl]);

    var fo = 0;

    function setFo(fo) {
        console.log("FOOOO: " + fo);
        this.fo = fo;
    }

    function LocationCtrl (locationRepository) {
        var vm = this;

        locationRepository.getLocation(fo).then(function (results) {
            vm.locations = results;
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;

        });
    }

}());