"use strict";
(function () {

    angular.module("app").controller("assetBMOController", ["brandRepository", "modelRepository", "osRepository", AssetBMOCtrl]);

    function AssetBMOCtrl (brandRepository, modelRepository, osRepository) {
        var vm = this;

        /*
         * Brand
         */
        brandRepository.getBrand().then(function (results) {
            vm.brands = results;
            console.log("Brands: ");
            console.log(vm.brands);
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });

         /*
         * Model
         */
        modelRepository.getModel().then(function (results) {
            vm.models = results;
            console.log("Models:");
            console.log(vm.models);
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });

         /*
         * Os
         */
        osRepository.getOs().then(function (results) {
            vm.operatingSystems = results;
            console.log("OperatingSystems: ");
            console.log(vm.operatingSystems)
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });
    }
}());