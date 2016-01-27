"use strict";

(function () {

    angular.module("app").service("securityManager", ["$log",  SecurityManager]);

    function SecurityManager($log) {
        $log.debug("In SecurityManager");

        var userCredentials;

         this.setUserCredentials = function (credentials) {
            console.log(credentials.username);
            userCredentials = credentials;
         };

         this.getUserCredentials = function () {
            return userCredentials;
         };
    }
}());