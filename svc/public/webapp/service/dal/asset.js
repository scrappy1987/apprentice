"use strict";

(function () {

    angular.module("app").service("assetDal", ["serviceCaller", AssetDal]);

    function AssetDal (serviceCaller) {
        $log.debug("Instantiated assetDal");
    }
}());
