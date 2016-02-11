"use strict";

(function () {

    angular.module('app').controller("manageAssetFormController", ["$log", "$state", ManageAssetFormCtrl]);

    function ManageAssetFormCtrl($log, $state) {
        var vm = this;

        vm.hasValidationError = false;
        vm.functionalOrg = {};
        vm.location = {};
        vm.contact = {};
        vm.asset = {};
    }
}());
