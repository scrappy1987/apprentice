"use strict";
(function () {

    angular.module("app")
        .controller("dashboardController",
        ["$log", DashboardCtrl]);

    function DashboardCtrl ($log) {
        var vm = this;
        $log.debug("Instantiated dashboardController controller");


        vm.addAsset = function () {

            var popupDialog = BootstrapDialog.show({
                message: 'This Button Works!'
            });
        }

         vm.manageAsset = function () {

            var popupDialog = BootstrapDialog.show({
                message: 'This Button Works Too!'
            });
        }
    }
}());