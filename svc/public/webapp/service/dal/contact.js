"use strict";

(function () {

    angular.module("app").service("contactDal", ["serviceCaller", ContactDal]);

    function ContactDal (serviceCaller) {
        $log.debug("Instantiated contactDal");

        this.getContact = function () {
            return serviceCaller.http.GET("contact");
        };
    }
}());
