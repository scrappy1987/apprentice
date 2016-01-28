"use strict";

(function () {
    angular.module("app")
        .controller("homeController",
        ["$state", "$log", HomeCtrl]);

    function HomeCtrl($state, $log) {
        var vm = this;
        $log.debug("Instantiated homeController controller");
        
        vm.isAtDashboard = function () {
            return $state.is("home.dashboard");
        };

        vm.isAtAsset = function() {
            return $state.is("home.assetmanage");
        };

        vm.navigateToDashboard = function () {
            $state.go("home.dashboard");
        };

        vm.navigateToManageAsset = function () {
            $state.go("home.assetmanage");
        };

        vm.logout = function () {
            $state.go("login");
        };
    }
}());