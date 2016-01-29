"use strict";

(function () {

    angular.module("app").service("functionalOrganisationDal", ["serviceCaller", FunctionalOrganisationDal]);

    function FunctionalOrganisationDal (serviceCaller) {
        $log.debug("Instantiated functionalOrganisationDal");

        this.getFunctionalOrganisation = function () {
            return service-caller.http.GET("functionalOrganisation");
        };
    }
}());
