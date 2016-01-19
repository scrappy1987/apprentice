"use strict";

(function () {

    angular.module('app')
        .controller("manageAssetController",
        ["$log", ManageAssetCtrl]);

    function ManageAssetCtrl($log) {
        var vm = this;
        $log.debug("Instantiated manageAssetController controller");
    }
}());