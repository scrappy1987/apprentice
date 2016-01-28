"use strict";
(function () {

    angular.module("app")
        .controller("assetManageController",
        ["$log", AssetManageCtrl]);

    function AssetManageCtrl ($log) {
        var vm = this;
        $log.debug("Instantiated assetManageController controller");
    }
}());