"use strict";

(function () {

    angular.module("app")
        .controller("loginController",
        ["$state", LoginCtrl]);

    function LoginCtrl($state) {
        var vm = this;

        vm.login = function () {
            $state.go("home.dashboard");
        };
    }
}());
