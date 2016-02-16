"use strict";

(function () {

    angular.module("app").service("contactDal", ["serviceCaller", ContactDal]);
    console.log("In ContactDal");
    function ContactDal (serviceCaller) {


        this.getContact = function (id) {
            return serviceCaller.http.GET("contact/" + id);
        };
    }
}());
