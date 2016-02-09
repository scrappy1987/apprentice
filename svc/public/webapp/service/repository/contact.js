"use strict";

(function () {

    angular.module("app").service("contactRepository", ["$q", "contactDal", ContactRepo]);

    function ContactRepo($q, contactDal) {

        var contactCache = [];
        console.log("This is contact cache");

        this.getContact = function (id) {
            var deferred = $q.defer();
            contactDal.getContact(id).then(function (results) {
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