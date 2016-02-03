"use strict";

(function () {

    angular.module("app").service("contactRepository", ["$q", "$log", "contactDal", ContactRepo]);

    function ContactRepo($q, $log, contactDal) {
        $log.debug("Instantiated contactRepository");

        var contactCache = [];
        console.log("This is contact cache");

        this.getContact = function () {
            var deferred = $q.defer();
            contactDal.getContact().then(function (results) {
            console.log("***Repository in success the value of results is***");
                    console.log(results);
                contactCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
    }
}());