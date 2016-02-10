"use strict";

(function () {

    angular.module("app").service("propertyTypeDal", ["serviceCaller", PropertyTypeDal]);

    function PropertyTypeDal (serviceCaller) {


        this.getPropertyType = function () {
            return serviceCaller.http.GET("propertytype");
        };
    }
}());