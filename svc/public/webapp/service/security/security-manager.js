"use strict";

(function () {

    angular.module("app").service("securityManager", ["$log", "serviceCaller", SecurityManager]);

    function SecurityManager($log, serviceCaller) {
        $log.debug("In SecurityManager");

         this.setUserCredentials = function (credentials) {
            this.userCredentials = credentials;
         };

         this.getUserCredentials = function () {
            return userCredentials;
         };

         this.userAuthentication = function (userCredentials) {
             serviceCaller.http.POST("/app/login", userCredentials).then(function (authenticate) {
                console.log("POST Request Success");
             }, function (error) {
                console.log("POST Request Failed");
             });
         };

         this.logIn = function(credentials){
            $log.debug("In logIn Function");
            var userCredentials;

            this.setUserCredentials(credentials);
            console.log(credentials.username);
            this.userAuthentication(userCredentials);
         };
    }
}());