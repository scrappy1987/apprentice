"use strict";

(function () {

    angular.module("app").service("assetDal", ["serviceCaller", AssetDal]);

    function AssetDal (serviceCaller) {
        $log.debug("Instantiated assetDal");

        this.getAsset = function () {
            return serviceCaller.http.GET("asset");
        };

        this.saveAsset = function (assetToSave) {
            return serviceCaller.http.POST("asset", assetToSave);
        };

        this.updateAsset = function (assetToUpdate) {
            return serviceCaller.http.PUT("asset/", assetToUpdate);
        };

        this.deleteAsset = function (assetToDelete) {
            return serviceCaller.http.DELETE("asset/", assetToDelete);
        };
    }
}());
