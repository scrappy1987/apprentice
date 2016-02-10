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
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });

         /*
         * Model
         */
        modelRepository.getModel().then(function (results) {
            vm.models = results;
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });

         /*
         * Os
         */
        osRepository.getOs().then(function (results) {
            vm.operatingsystems = results;
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });
    }
}());