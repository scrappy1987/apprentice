"use strict";

(function () {

    angular.module('app').controller("locationFormController", ["$log", "locationRepository", "$state", LocationFormCtrl]);

    function LocationFormCtrl($log, locationRepository, $state) {
        var vm = this;

        vm.hasValidationError = false;
        vm.location = {};

    }
}());
