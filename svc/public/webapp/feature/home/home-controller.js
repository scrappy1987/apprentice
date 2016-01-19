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

        vm.isAtAsset = function () {
            return $state.includes("home.asset");
        };

        vm.navigateToDashboard = function () {
            $state.go("home.dashboard");
        };

        vm.navigateToAsset = function () {
            $state.go("home.asset");
        };

        vm.navigateToAddAsset = function () {
            $state.go("home.addasset");
        };

        vm.logout = function () {
            $state.go("login");
        };
    }
}());