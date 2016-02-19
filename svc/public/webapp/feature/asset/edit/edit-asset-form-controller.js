"use strict";

 (function () {

     angular.module('app').controller("editAssetFormController", ["$log", "$state", "$stateParams", "assetRepository", EditAssetFormCtrl]);

     function EditAssetFormCtrl($log, $state, $stateParams, assetRepository) {
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
             setAssetValues(assetForm);
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

         function setAssetValues(assetForm) {
                for(var key = 0; key < Object.keys(vm.asset).length; key++) {
                        var assetKey = Object.keys(vm.asset)[key];
                        if (assetKey in assetForm) {
                            vm.asset[assetKey] = assetForm[assetKey].$$rawModelValue;
                        }
                }
         }
     }
 }());