var productApp = angular.module('productApp', ["ngRoute"]);

productApp.config(function ($routeProvider, $locationProvider) {
    $locationProvider.hashPrefix("");
    $routeProvider
        .otherwise({
            templateUrl: "./page/home.html",
        })
        .when("/login", {
            templateUrl: "./page/login.html",
        })
        .when("/home", {
            templateUrl: "./page/home.html",
        })
        .when("/add", {
            templateUrl: "./page/add.html",
        })
        .when("/update", {
            templateUrl: "./page/update.html",
        })
        .when("/update/:id", {
            templateUrl: "./page/update.html",
        })
        .when("/detail/:id",{
            templateUrl: "./page/detail.html"
        })

})

productApp.controller("productCtrl", productCtrl);
