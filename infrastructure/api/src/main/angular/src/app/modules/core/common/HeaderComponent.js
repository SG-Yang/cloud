"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
/**
 * Created by aheroboy on 15/6/2017.
 */
var core_1 = require("@angular/core");
var HeaderComponent = (function () {
    function HeaderComponent() {
        this.name = 'HeaderComponent';
    }
    return HeaderComponent;
}());
HeaderComponent = __decorate([
    core_1.Component({
        selector: 'app-header',
        template: "<header class=\"w3-top w3-border-dark-grey w3-blue-grey w3-large w3-padding \">\n    <div style=\"z-index:4\">\n      <div class=\"w3-left\">\n        <span class=\"w3-opennav w3-xlarge\" onmouseover=\"w3_open()\">&#9776;</span>\n      </div>\n      <span class=\"w3-right\">Logo</span>\n    </div>\n  </header>",
    })
], HeaderComponent);
exports.HeaderComponent = HeaderComponent;
//# sourceMappingURL=HeaderComponent.js.map