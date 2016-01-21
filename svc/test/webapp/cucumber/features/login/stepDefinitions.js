// Do login for each test

var LoginPage = require("../../page-models/login.page.js");
var assert = require('assert');

module.exports = function () {

    this.setDefaultTimeout(60000);
    var login = new LoginPage;

    this.Given(/I am on the login view/, function (next) {
        login.visitPage().then(function () {
            next();
        });
    });

    this.Given(/^I supply a valid username$/, function (next) {
        login.fillUsername("admin").then(function () {
            next();
        })
    });

    this.Given(/^I supply a valid password/, function (next) {
        login.fillPassword("password").then(function () {
            next();
        })
    });

    this.When(/^I login$/, function (next) {
        login.login().then(function () {
            next();
        });
    });

    this.Then(/^I see the dashboard$/, function (next) {
        login.currentURL().then(function (currentURL) {
            assert.equal("http://localhost:9000/#/dashboard", currentURL);
            next();
        });
    });

};
