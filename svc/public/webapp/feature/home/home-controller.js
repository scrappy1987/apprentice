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

        vm.isAtAssetAdd = function() {
            return $state.is("home.assetadd");
        };
        vm.isAtAssetEdit = function() {
             return $state.is("home.assetedit");
         };

        vm.navigateToDashboard = function () {
            $state.go("home.dashboard");
        };

        vm.navigateToManageAsset = function () {
            $state.go("home.assetmanage");
        }

        vm.navigateToEditAsset = function (id) {
            $state.go("home.assetedit");
        }

         vm.navigateToAssetAdd = function () {
                $state.go("home.assetadd");
            }

        vm.logout = function () {
            $state.go("login");
        };
    }
}());