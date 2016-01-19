"use strict";

(function () {

    angular.module('app').config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("login");

        $stateProvider.state("login", {
            url: "/login",
            views: {
                "content": {
                    templateUrl: "feature/login/login-index.html"
                }
            }
        })
    });
}());


(function () {

    angular.module('app').config(function ($stateProvider) {
        $stateProvider.state("home", {
            abstract: true,
            views: {
                "content": {
                    templateUrl: "feature/home/home-index.html"
                }
            }
        }).state("home.dashboard", {
            url: "/dashboard",
            views: {
                "home-content": {
                    templateUrl: "feature/dashboard/dashboard-index.html"
                }
            }
        }).state("home.asset", {
            url: "/asset",
            views: {
                "home-content": {
                    templateUrl: "feature/asset/manage-asset.html"
                }
            }
        }).state("home.addasset", {
            url: "/asset/addasset",
            views: {
                "home-content": {
                    templateUrl: "feature/asset/add-asset.html"
                }
            }
        })
    });
}());
