"use strict";

(function () {

    angular.module("app")
        .controller("loginController",
        ["$state", "$log", LoginCtrl]);

    function LoginCtrl($state, $log) {
        var vm = this;
        $log.debug("Instantiated loginController controller");

        vm.login = function () {
            $state.go("home.dashboard");
        };
    }
}());
