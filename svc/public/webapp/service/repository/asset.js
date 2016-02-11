"use strict";

(function () {

    angular.module("app").service("assetRepository", ["$q", "$log", "assetDal", AssetRepo]);

    function AssetRepo($q, $log, assetDal) {
        $log.debug("Instantiated assetRepository");

        var assetCache = [];
        console.log("This is asset cache");

        this.getAsset = function (id) {

            var deferred = $q.defer();
            assetDal.getAsset(id).then(function (results) {
            console.log("***ASSETRepository in success the value of results is***");
                    console.log(results);
                assetCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };

        this.saveAsset = function (assetToSave) {

        var deferred = $q.defer();
        var isUpdate = assetToSave.hasOwnProperty("id");

        assetDal.saveAsset(assetToSave).then(function (asset) {

                if (!isUpdate) {
                    assetCache.push(asset);
                }
                deferred.resolve(asset);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };

        this.deleteAsset = function (assetToDelete) {

            var deferred = $q.defer();
            assetDal.deleteAsset(assetToDelete).then(function (assets) {
                console.log("IN MANGE");
                _.remove(assetCache, {
                    id: assetToDelete.id
                });

                deferred.resolve(assetCache);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
            $log.debug("Repository:Asset Instantiated");
        }
}());