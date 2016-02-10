"use strict";

(function () {

    angular.module('app').controller("addAssetFormController", ["$log", "$state", "assetRepository", AddAssetFormCtrl]);

    function AddAssetFormCtrl($log, $state, assetRepository) {
        var vm = this;

        vm.hasValidationError = false;

        vm.asset = {};

        vm.saveAsset = function (assetForm) {
            $log.debug("In asset form controller");

            var waitingDialog = BootstrapDialog.show({
                message: 'Please wait - creating asset'
            });

            assetRepository.saveAsset(vm.asset).then(function (asset) {

                waitingDialog.close();
                BootstrapDialog.show({
                    message: 'Asset saved successfully',
                    buttons: [{
                        id: 'button-close',
                        label: 'Close',
                        action: function (dialogWindow) {
                            dialogWindow.close();
                            $state.go("home.dashboard");
                        }
                    }]
                });

            }, function(error) {

                waitingDialog.close();
                $log.debug(error);

            });
        }
    }
}());
