"use strict";

(function () {

    angular.module("app").service("assetDal", ["serviceCaller", AssetDal]);

    function AssetDal (serviceCaller) {
        $log.debug("Instantiated assetDal");

        this.getAsset = function () {
            return service-caller.http.GET("asset");
        };

        this.saveAsset = function (assetToSave) {
            return service-caller.http.POST("asset", assetToSave);
        };

        this.updateAsset = function (assetToUpdate) {
            return service-caller.http.PUT("asset/", assetToUpdate);
        };

        this.deleteAsset = function (assetToDelete) {
            return service-caller.http.DELETE("asset/", assetToDelete);
        };
    }
}());
