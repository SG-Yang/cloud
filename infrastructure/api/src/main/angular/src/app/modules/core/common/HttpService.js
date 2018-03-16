"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var Observable_1 = require("rxjs/Observable");
var http_1 = require("@angular/http");
var HttpService = (function () {
    function HttpService(component, http) {
        this.component = component;
        this.http = http;
        this.url = 'http://localhost:8090/'; // URL to web API
        this.headers = new http_1.Headers({ 'Content-Type': 'application/json' });
    }
    HttpService.prototype.getItems = function (pathUrl) {
        ;
        return this.http.get(this.url + this.component + "/" + pathUrl)
            .map(this.extractData)
            .catch(this.handleError);
    };
    HttpService.prototype.postItems = function (domain) {
        return this.http.post(this.url + this.component, domain)
            .map(this.extractData)
            .catch(this.handleError);
    };
    HttpService.prototype.extractData = function (res) {
        var body = res.json();
        return body.voBody || {};
    };
    HttpService.prototype.handleError = function (error) {
        var errMsg;
        if (error instanceof http_1.Response) {
            var body = error.json() || '';
            var err = body.error || JSON.stringify(body);
            errMsg = error.status + " - " + (error.statusText || '') + " " + err;
        }
        else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable_1.Observable.throw(errMsg);
    };
    return HttpService;
}());
HttpService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [String, http_1.Http])
], HttpService);
exports.HttpService = HttpService;
//# sourceMappingURL=HttpService.js.map