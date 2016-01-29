"use strict";

(function () {

    angular.module("app").service("contactDal", ["serviceCaller", ContactDal]);

    function ContactDal (serviceCaller) {
        $log.debug("Instantiated contactDal");

        this.getContact = function () {
            return service-caller.http.GET("contact");
        };
    }
}());
