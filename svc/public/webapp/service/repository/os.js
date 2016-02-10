"use strict";

(function () {

    angular.module("app").service("osRepository", ["$q", "osDal", OsRepo]);

    function OsRepo($q, osDal) {

        var osCache = [];
        console.log("This is os cache");

        this.getOs = function () {
            var deferred = $q.defer();
            osDal.getOs().then(function (results) {
            console.log("***Repository in success the value of results is***");
                    console.log(results);
                osCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
    }
}());