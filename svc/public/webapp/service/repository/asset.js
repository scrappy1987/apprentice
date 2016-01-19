"use strict";

(function () {

    angular.module("app").service("assetRepository", ["$q", "$log", "assetDal", AssetRepo]);

    function AssetRepo($q, $log, assetDal) {

        var assetCache = [];
        $log.debug("Instantiated assetRepository");

        this.getAssets = function () {
            $log.debug("Repository: getAssets called");

            var deferred = $q.defer();
            assetDal.getAssets().then(function (results) {
                $log.debug("Repository: getAssets promise successful the value of results is:");
                $log.debug(results);
                assetCache = results;
                deferred.resolve(results);
            }, function (error) {
                $log.debug("Repository: getAssets promise failed the value of error is:");
                $log.debug(error);
                deferred.reject(error);
            });
            return deferred.promise;
        };

        //Create or update an asset.  An asset with no ID is a new asset.
        this.saveAsset = function (assetToSave) {
            $log.debug("Repository: saveAsset called");

            var deferred = $q.defer();
            var isAnUpdateToAnAsset = assetToSave.hasOwnProperty("id");

            assetDal.saveAsset(assetToSave).then(function (asset) {

                if (!isAnUpdateToAnAsset) {
                    assetCache.push(asset);
                }

                $log.debug("Repository: saveAsset promise successful the value of asset is:");
                $log.debug(asset);
                deferred.resolve(asset);
            }, function (error) {
                $log.debug("Repository: saveAsset promise failed the value of error is:");
                $log.debug(error);
                deferred.reject(error);
            });

            return deferred.promise;
        };

        this.deleteAsset = function (assetToDelete) {
            $log.debug("Repository: deleteAsset called");

            var deferred = $q.defer();
            assetDal.deleteAsset(assetToDelete).then(function (assets) {
                _.remove(assetCache, {
                    id: assetToDelete.id
                });
                $log.debug("Repository: deleteAsset promise successful the value of assets is:");
                $log.debug(assets);
                deferred.resolve(assetCache);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };
    }
}());