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
        }).state("home.assetmanage", {
                      url: "/asset",
                      views: {
                          "home-content": {
                             templateUrl: "feature/asset/manage/manage-asset-index.html"
                          }
                      }
          }).state("home.assetadd", {
                                  url: "/asset/add",
                                  views: {
                                      "home-content": {
                                         templateUrl: "feature/asset/add/add-asset-index.html"
                                      }
                                  }
                      })
        });
}());
