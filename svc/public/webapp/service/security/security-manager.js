"use strict";

(function () {

    angular.module("app").service("securityManager", ["$q", "$log", "serviceCaller", SecurityManager]);

    function SecurityManager($q, $log, serviceCaller) {
        $log.debug("In SecurityManager");

        var loginResponse;

         this.setUserCredentials = function (userCredentials) {
            this.userCredentials = userCredentials;
         };

         this.getUserCredentials = function () {
            return userCredentials;
         };

         this.logIn = function (userCredentials) {
             $log.debug("In logIn Function");
             this.setUserCredentials(userCredentials);
             var deferred = $q.defer();
             console.log(userCredentials);

            try {
                 serviceCaller.http.POST("/login", userCredentials).then(function (loginResponse, error) {
                    deferred.resolve(loginResponse);
                 }, function (error) {
                    console.log(error);
                 });
             } catch (e) {
                deferred.reject(e);
             }
             return deferred.promise;
         };
    }
}());