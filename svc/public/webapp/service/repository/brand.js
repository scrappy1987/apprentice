"use strict";

(function () {

    angular.module("app").service("brandRepository", ["$q", "brandDal", BrandRepo]);

    function BrandRepo($q, brandDal) {

        var brandCache = [];
        console.log("This is brand cache");

        this.getBrand = function () {
            var deferred = $q.defer();
            brandDal.getBrand().then(function (results) {
            console.log("***Repository in success the value of results is***");
                    console.log(results);
                brandCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
    }
}());