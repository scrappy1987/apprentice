"use strict";

(function () {

    angular.module("app").service("modelRepository", ["$q", "modelDal", ModelRepo]);

    function ModelRepo($q, modelDal) {

        var modelCache = [];
        console.log("This is model cache");

        this.getModel = function () {
            var deferred = $q.defer();
            modelDal.getModel().then(function (results) {
            console.log("***Repository in success the value of results is***");
                    console.log(results);
                modelCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
    }
}());