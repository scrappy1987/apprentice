"use strict";

(function () {

    angular.module("app").service("osDal", ["serviceCaller", OsDal]);

    function OsDal (serviceCaller) {


        this.getOs = function () {
            return serviceCaller.http.GET("operatingsystems");
        };
    }
}());