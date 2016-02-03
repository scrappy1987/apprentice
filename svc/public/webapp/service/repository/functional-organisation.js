"use strict";

(function () {

    angular.module("app").service("functionalOrganisationRepository", ["$q", "$log", "functionalOrganisationDal", FunctionalOrganisationRepo]);

    function FunctionalOrganisationRepo($q, $log, functionalOrganisationDal) {
        $log.debug("Instantiated functionalOrganisationRepository");

        var functionalOrganisationCache = [];
        console.log("This is functional org cache");

        this.getFunctionalOrganisation = function () {
            var deferred = $q.defer();
            functionalOrganisationDal.getFunctionalOrganisation().then(function (results) {
            console.log("***Repository in success the value of results is***");
                    console.log(results);
                functionalOrganisationCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
    }
}());