"use strict";

(function () {

    angular.module("app").service("statusDal", ["serviceCaller", StatusDal]);

    function StatusDal (serviceCaller) {


        this.getStatus = function () {
            return serviceCaller.http.GET("status");
        };
    }
}());