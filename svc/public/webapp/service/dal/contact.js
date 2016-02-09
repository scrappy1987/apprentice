"use strict";

(function () {

    angular.module("app").service("contactDal", ["serviceCaller", ContactDal]);

    function ContactDal (serviceCaller) {


        this.getContact = function (id) {
            return serviceCaller.http.GET("contact/" + id);
        };
    }
}());
