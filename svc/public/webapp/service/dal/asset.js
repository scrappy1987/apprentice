"use strict";

(function () {

    angular.module("app").service("assetDal", ["serviceCaller", AssetDal]);

    function AssetDal (serviceCaller) {
        console.log("Instantiated assetDal");

        this.getAsset = function (id) {
            return serviceCaller.http.GET("contact/" + id + "/asset");
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
