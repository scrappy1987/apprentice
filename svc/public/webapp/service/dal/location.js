"use strict";

(function () {

    angular.module("app").service("locationDal", ["serviceCaller", LocationDal]);

    function LocationDal (serviceCaller) {
        $log.debug("Instantiated assetDal");

        this.getLocation = function () {
            return service-caller.http.GET("location");
        };
    }
}());
