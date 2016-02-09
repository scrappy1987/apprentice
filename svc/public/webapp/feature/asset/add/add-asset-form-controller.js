"use strict";

(function () {

    angular.module('app').controller("addAssetFormController", ["$log", "$state", AddAssetFormCtrl]);

    function AddAssetFormCtrl($log, $state) {
        var vm = this;

        vm.hasValidationError = false;
        vm.functionalOrg = {};
        vm.location = {};
    }
}());
