"use strict";

(function () {

    angular.module("app").service("functionalOrganisationDal", ["serviceCaller", FunctionalOrganisationDal]);

    function FunctionalOrganisationDal (serviceCaller) {
        this.getFunctionalOrganisation = function () {
            return serviceCaller.http.GET("functionalorg");
        };
    }
}());
