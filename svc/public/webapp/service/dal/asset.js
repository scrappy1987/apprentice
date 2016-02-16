"use strict";

(function () {

    angular.module("app").service("assetDal", ["serviceCaller", AssetDal]);

    function AssetDal (serviceCaller) {

        this.getAssetFromContact = function (id) {
            return serviceCaller.http.GET("contact/" + id + "/asset");
        };

        this.getAsset = function (id) {
            return serviceCaller.http.GET("asset/edit/" + id);
        };

        this.saveAsset = function (assetToSave) {
            return serviceCaller.http.POST("asset", assetToSave);

        };

        this.updateAsset = function (assetToUpdate) {
            return serviceCaller.http.PUT("asset", assetToUpdate);
        };

        this.deleteAsset = function (assetToDelete) {
            return serviceCaller.http.DELETE("asset/resource/", assetToDelete);
        };
    }
}());
