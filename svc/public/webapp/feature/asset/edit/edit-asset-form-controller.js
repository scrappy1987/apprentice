"use strict";

 (function () {

     angular.module('app').controller("editAssetFormController", ["$log", "$state", "$stateParams", "assetRepository", EditAssetFormCtrl]);

     function EditAssetFormCtrl($log, $state, $stateParams, assetRepository) {
         var vm = this;

         vm.hasValidationError = false;

         vm.asset = {};
         vm.asset.id = $state.params.assetId;

         console.log("ASSET ID: " + vm.asset.id);

         assetRepository.getAsset(vm.asset.id).then(function (results) {
             console.log("Edit Asset getAsset called");
             vm.asset = results;
             console.log(vm.asset);
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