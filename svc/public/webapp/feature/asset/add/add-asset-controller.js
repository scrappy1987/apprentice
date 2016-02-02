"use strict";
(function () {

    angular.module("app")
        .controller("assetAddController",
        ["$log", AssetAddCtrl]);

    function AssetAddCtrl ($log) {
        var vm = this;
        $log.debug("Instantiated assetAddController controller");
    }


}());