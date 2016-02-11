"use strict";

(function () {

    angular.module('app').controller("manageAssetFormController", ["$log", "$state", "assetRepository", ManageAssetFormCtrl]);

    function ManageAssetFormCtrl($log, $state, assetRepository) {
        var vm = this;

        vm.hasValidationError = false;
        vm.assets = {};


        vm.getAssets = function(id) {

            var waitingDialog = BootstrapDialog.show({
                message: 'Please Wait - retrieving asset'
            });

            assetRepository.getAsset(id).then (function(results) {

            waitingDialog.close();
                    console.log(results);

            if (results.length < 1) {

                 BootstrapDialog.confirm({
                     message: 'No assets available for this contact!',
                     type: BootstrapDialog.TYPE_INFO,
                     btnOKLabel: 'Ok!',
                     callback: function (confirmed) {
                        if (confirmed) {
                            $state.reload();
                            }
                    }
                });
            }
            else {
                vm.assets = results;
            }
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
       }

       vm.deleteAsset = function(asset) {

             var waitingDialog;

                BootstrapDialog.confirm({
                    message: 'Are you sure that you want to delete this asset?',
                    type: BootstrapDialog.TYPE_WARNING,
                    btnOKLabel: 'Delete!',
                    btnOKClass: 'btn-warning',
                    callback: function (confirmed) {

                    if (confirmed) {
                        waitingDialog = BootstrapDialog.show({
                            message: 'Please Wait - deleting asset'
                        });

                        assetRepository.deleteAsset(asset).then(function(results) {
                            waitingDialog.close();
                        console.log(results);
                            vm.assets = results;
                            $state.reload();
                        }, function (error) {

                         });
                    }
                }
            })
        };



}
}());