"use strict";

(function () {

    angular.module("app").service("brandDal", ["serviceCaller", BrandDal]);

    function BrandDal (serviceCaller) {


        this.getBrand = function () {
            return serviceCaller.http.GET("brands");
        };
    }
}());