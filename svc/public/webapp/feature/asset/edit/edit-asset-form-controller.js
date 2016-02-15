"use strict";

(function () {

    angular.module('app').controller("editAssetFormController", ["$log", "$state", "assetRepository", "$stateParams", EditAssetFormCtrl]);

    function EditAssetFormCtrl($log, $state, assetRepository, $stateParams ) {
        var vm = this;

        vm.hasValidationError = false;

        vm.asset = {};
        vm.asset.id = $state.params.assetId;

        assetRepository.getAsset(vm.asset.id).then(function (results) {

            vm.asset = results;
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });

        vm.saveAsset = function (assetForm) {
            $log.debug("In asset form controller");

            var waitingDialog = BootstrapDialog.show({
                message: 'Please wait - updating asset'
            });

            assetRepository.saveAsset(vm.asset).then(function (asset) {

                waitingDialog.close();
                BootstrapDialog.show({
                    message: 'Asset updated successfully',
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