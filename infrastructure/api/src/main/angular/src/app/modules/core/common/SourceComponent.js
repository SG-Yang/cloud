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
var SourceComponent = (function () {
    function SourceComponent() {
        this.foods = [
            { value: 'steak-0', viewValue: 'Steak' },
            { value: 'pizza-1', viewValue: 'Pizza' },
            { value: 'tacos-2', viewValue: 'Tacos' }
        ];
    }
    return SourceComponent;
}());
SourceComponent = __decorate([
    core_1.Component({
        selector: 'app-sources',
        template: "\n      <div style=\"margin-top: 20px; border: 10px; border-color: #00acc1\">\n         <label>Source Management</label> \n          <div>\n              <table border=\"1px;solid\">\n                  <tr>\n                      <td><label>SourceType:</label></td>\n                      <td>\n                      </td>\n                  </tr>\n              </table>\n          </div>\n      </div>\n    ",
    })
], SourceComponent);
exports.SourceComponent = SourceComponent;
//# sourceMappingURL=SourceComponent.js.map