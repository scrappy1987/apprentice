"use strict";

(function () {

    angular.module('app')
        .controller("addAssetController",
        ["$log", AddAssetCtrl]);

    function AddAssetCtrl($log) {
        var vm = this;
        $log.debug("Instantiated addAssetController controller");
    }

}());