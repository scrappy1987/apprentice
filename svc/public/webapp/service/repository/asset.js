"use strict";

(function () {

    angular.module("app").service("assetRepository", ["$q", "$log", "assetDal", AssetRepo]);

    function AssetRepo($q, $log, assetDal) {
        $log.debug("Instantiated assetRepository");

        var assetCache = [];

        this.getAsset = function (criteria) {
            var deferred = $q.defer();
            assetDal.getAsset().then(function (results) {
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