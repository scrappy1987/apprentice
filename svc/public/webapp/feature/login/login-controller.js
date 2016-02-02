"use strict";

     (function () {

         angular.module("app").controller("loginController", ["$state", "$log", "securityManager", LoginCtrl]);

         function LoginCtrl($state, $log, securityManager) {
          $log.debug("In loginController");
             var vm = this;

             vm.login = function () {

                 vm.credentials = {"user1@atos.net" : "password1"};
//                 vm.credentials = {username: vm.username, password: vm.password};

                 securityManager.logIn(vm.credentials).then(function (response, error) {
                     if (response.authenticated === "true") {
                      $state.go("home.dashboard");
                     } else {
                     location.reload();
                     }
                 }, function (error) {
                     $log.debug("Authentication Error");
                     console.log(error);
                 });
             };
         };
     }());
