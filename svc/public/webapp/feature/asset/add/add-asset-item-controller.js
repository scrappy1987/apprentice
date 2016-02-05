"use strict";

(function () {
    /**
     * Manages individual functional orgs within a ng-repeat set
     */
    angular.module('app')
        .controller("AssetItemController",
            ["$state", "functionalOrganisationRepository", FOItemCtrl]);

    function FOItemCtrl($state, functionalOrganisationRepository) {

    }

}());