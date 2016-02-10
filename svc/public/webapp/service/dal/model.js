"use strict";

(function () {

    angular.module("app").service("modelDal", ["serviceCaller", ModelDal]);

    function ModelDal (serviceCaller) {


        this.getModel = function () {
            return serviceCaller.http.GET("models");
        };
    }
}());