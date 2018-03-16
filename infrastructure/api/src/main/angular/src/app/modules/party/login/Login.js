/**
 * Created by aheroboy on 4/11/2017.
 */
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
var User_1 = require("./User");
var HttpService_1 = require("../../core/common/HttpService");
var UserLoginService_1 = require("./UserLoginService");
var LoginComponent = (function () {
    function LoginComponent(userService) {
        this.userService = userService;
        this.name = "LoginComponent";
        this.model = new User_1.User(0, 'sg', 'yang');
        this.submitted = false;
    }
    LoginComponent.prototype.onSubmit = function () {
        var _this = this;
        this.submitted = true;
        this.userService.postItems(this.model).subscribe(function (outUser) {
            _this.model = outUser;
        });
    };
    Object.defineProperty(LoginComponent.prototype, "diagnostic", {
        get: function () {
            return JSON.stringify(this.model);
        },
        enumerable: true,
        configurable: true
    });
    return LoginComponent;
}());
LoginComponent = __decorate([
    core_1.Component({
        selector: 'login-form',
        templateUrl: './userForm.html',
        providers: [HttpService_1.HttpService, UserLoginService_1.UserLoginService]
    }),
    __metadata("design:paramtypes", [UserLoginService_1.UserLoginService])
], LoginComponent);
exports.LoginComponent = LoginComponent;
//# sourceMappingURL=Login.js.map
