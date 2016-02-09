"use strict";

(function () {

    angular.module("app").service("locationDal", ["serviceCaller", LocationDal]);

    function LocationDal (serviceCaller) {

        this.getLocation = function (id) {
            return serviceCaller.http.GET("location/" + id);
        };
    }
}());
