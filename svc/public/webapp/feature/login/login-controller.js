"use strict";

(function () {

    angular.module("app")
        .controller("loginController",
        ["$state", "$log", "securityManager", LoginCtrl]);

    function LoginCtrl($state, $log, securityManager) {
        var vm = this;

        $log.debug("Instantiated loginController controller");

        vm.login = function () {
        vm.credentials = {username: vm.username, password: vm.password};

        securityManager.logIn(vm.credentials)

        $state.go("home.dashboard");
        };
    }
}());
