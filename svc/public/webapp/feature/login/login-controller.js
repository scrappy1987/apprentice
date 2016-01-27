"use strict";

(function () {

    angular.module("app")
        .controller("loginController",
        ["$state", "$log", LoginCtrl]);

    function LoginCtrl($state, $log) {
        var vm = this;

        $log.debug("Instantiated loginController controller");

        vm.login = function () {
        vm.credentials = {username: vm.username, password: vm.password};

        console.log(vm.credentials);
        $state.go("home.dashboard");
        };
    }

}());
