"use strict";

(function () {

    angular.module("app").service("assetRepository", ["$q", "$log", "assetDal", AssetRepo]);

    function AssetRepo($q, $log, assetDal) {
        $log.debug("Instantiated assetRepository");
    }
}());