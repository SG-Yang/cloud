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
/**
 * Created by aheroboy on 15/6/2017.
 */
var core_1 = require("@angular/core");
var MenuService_1 = require("./MenuService");
var Params_1 = require("./Params");
var NavBarComponent = (function () {
    function NavBarComponent(menuService) {
        this.menuService = menuService;
    }
    NavBarComponent.prototype.ngOnInit = function () {
        this.getMenuItems();
    };
    NavBarComponent.prototype.getMenuItems = function () {
        var _this = this;
        var params = new Params_1.Params();
        params.params = ["root", 1];
        this.menuService.getItems(params.toPathUrl())
            .subscribe(function (items) { return _this.items = items; }, function (error) { return _this.errorMessage = error; });
    };
    return NavBarComponent;
}());
NavBarComponent = __decorate([
    core_1.Component({
        selector: 'app-nav',
        providers: [MenuService_1.MenuService],
        template: "\n    <nav class=\"w3-sidenav w3-blue-grey w3-border-blue-grey w3-animate-left \"\n         style=\"margin-top: 30px\"\n         onmouseleave=\"w3_close()\"><br>\n      <a *ngFor=\"let item of items\" routerLink=\"{{item.url}}\" routerLinkActive=\"active\">{{item.name}}</a>\n    </nav>",
    }),
    __metadata("design:paramtypes", [MenuService_1.MenuService])
], NavBarComponent);
exports.NavBarComponent = NavBarComponent;
//# sourceMappingURL=NavBarComponent.js.map
