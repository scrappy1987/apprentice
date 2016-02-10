"use strict";

(function () {

    angular.module("app").service("statusRepository", ["$q", "statusDal", StatusRepo]);

    function StatusRepo($q, statusDal) {

        var statusCache = [];
        console.log("This is brand cache");

        this.getStatus = function () {
            var deferred = $q.defer();
            statusDal.getStatus().then(function (results) {
            console.log("***Repository in success the value of results is***");
                    console.log(results);
                statusCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
    }
}());