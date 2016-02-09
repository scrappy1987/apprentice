"use strict";

(function () {

    angular.module('app').controller("locationItemController", ["$state", "locationRepository", LocationItemCtrl]);

    function LocationItemCtrl($state, locationRepository) {
        var vm = this;
        // name constant - for trace and debugging
        vm.controllerName = "locationItemController";

    }
}());