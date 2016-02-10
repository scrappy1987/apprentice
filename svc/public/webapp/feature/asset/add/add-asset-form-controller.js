"use strict";

(function () {

    angular.module('app').controller("addAssetFormController", ["$log", "$state", AddAssetFormCtrl]);

    function AddAssetFormCtrl($log, $state) {
        var vm = this;

        vm.hasValidationError = false;
        vm.functionalOrg = {};
        vm.location = {};
        vm.contact = {};


        vm.brand = {};
        vm.model = {};
        vm.os = {};

        vm.propertyType = {};
        vm.status = {};
    }
}());
