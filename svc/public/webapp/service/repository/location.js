"use strict";

(function () {

    angular.module("app").service("locationRepository", ["$q", "$log", "locationDal", LocationRepo]);

    function LocationRepo($q, $log, locationDal) {
        $log.debug("Instantiated locationRepository");

        var locationCache = [];
        console.log("This is location cache");

        this.getLocation = function () {
            var deferred = $q.defer();
            locationDal.getLocation().then(function (results) {
            console.log("***Repository in success the value of results is***");
                    console.log(results);
                locationCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
    }

}());