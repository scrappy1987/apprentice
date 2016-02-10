"use strict";

(function () {

    angular.module("app").service("propertyTypeRepository", ["$q", "propertyTypeDal", PropertyTypeRepo]);

    function PropertyTypeRepo($q, propertyTypeDal) {

        var propertyTypeCache = [];
        console.log("This is brand cache");

        this.getPropertyType = function () {
            var deferred = $q.defer();
            propertyTypeDal.getPropertyType().then(function (results) {
            console.log("***Repository in success the value of results is***");
                    console.log(results);
                propertyTypeCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
    }
}());