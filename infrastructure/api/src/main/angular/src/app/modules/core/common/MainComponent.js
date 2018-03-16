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
var forms_1 = require("@angular/forms");
var FormulaService_1 = require("./FormulaService");
var AxisService_1 = require("./AxisService");
var Params_1 = require("./Params");
var TypeService_1 = require("./TypeService");
var MainComponent = (function () {
    /**
      ngOnInit() {
        this.initReferences();
        this.canvasContext = this.canvas.nativeElement.getContext('2d');
        this.axisService.drawAxis(this.canvasContext);

      }
     **/
    function MainComponent(menuService, fb, formulaService, axisService, refService) {
        this.menuService = menuService;
        this.fb = fb;
        this.formulaService = formulaService;
        this.axisService = axisService;
        this.refService = refService;
        this.createForm();
        this.visible = 'visible';
    }
    MainComponent.prototype.initReferences = function () {
        var _this = this;
        var params = new Params_1.Params();
        params.params = ["FormulaMenu", 1];
        this.menuService.getItems(params.toPathUrl())
            .subscribe(function (items) { return _this.topMenu = items; }, function (error) { return _this.errorMessage = error; });
        this.refService.getItems("formula").subscribe(function (items) { return _this.formulaTypes = items; }, function (error) { return _this.errorMessage = error; });
        console.log(this.formulaTypes);
    };
    MainComponent.prototype.editP = function (event) {
        if (this.visible === 'visible') {
            this.visible = 'hidden';
        }
        else {
            this.visible = 'visible';
        }
    };
    MainComponent.prototype.drawDiagram = function (event) {
        var _this = this;
        this.formulaService.postItems(this.editForm.getRawValue()).subscribe(function (formula) { return _this.editForm = _this.fb.group(formula); }, function (error) { return _this.errorMessage = error; });
    };
    MainComponent.prototype.createForm = function () {
        this.editForm = this.fb.group({
            formulaValue: '',
            formulaType: '',
            formulaName: ''
        });
    };
    return MainComponent;
}());
__decorate([
    core_1.ViewChild('mainGraph'),
    __metadata("design:type", core_1.ElementRef)
], MainComponent.prototype, "canvas", void 0);
MainComponent = __decorate([
    core_1.Component({
        selector: 'app-main',
        providers: [MenuService_1.MenuService, FormulaService_1.FormulaService, AxisService_1.AxisService, TypeService_1.TypeService],
        styles: ["\n    form {\n      visibility: hidden;\n    }\n  "],
        template: "<div id=\"main\" style=\"margin-top: 30px;margin-left: 2%;\">\n    <section class=\"w3-container case\">\n      <nav class=\"w3-topnav w3-red\" style=\"margin-top: 30px;\">\n        <a *ngFor=\"let item of topMenu\" (click) = \"editP()\">{{item.name}}</a>\n      </nav>\n      <form [ngStyle]=\"{'visibility': visible,'height': '100px','border': '2px solid #5fee23'}\" [formGroup]=\"editForm\">\n        <div>\n          <label>Type:\n            <select formControlName = \"formulaType\">\n                <option value=\"abc\">abc</option>\n              <option *ngFor=\"let type of formulaTypes\" value=\"{{type.name}}\">{{type.value}}</option>\n            </select>\n          </label>\n          <label>Name:\n            <input type=\"text\" formControlName=\"formulaName\"> \n          </label>\n          <label>Formula:\n            <textarea formControlName=\"formulaValue\"></textarea>\n            <input type=\"button\" (click)=\"drawDiagram()\" value=\"draw\">\n          </label>\n        </div>\n      </form>\n        <canvas id=\"main-graph\" #mainGraph width=\"1020\" height=\"600\" style=\"border:1px solid\"></canvas>\n    </section>\n  </div>",
    }),
    __metadata("design:paramtypes", [MenuService_1.MenuService,
        forms_1.FormBuilder,
        FormulaService_1.FormulaService,
        AxisService_1.AxisService,
        TypeService_1.TypeService])
], MainComponent);
exports.MainComponent = MainComponent;
//# sourceMappingURL=MainComponent.js.map
