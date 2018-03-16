"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
require("rxjs/add/operator/catch");
require("rxjs/add/operator/map");
/**
 * Created by aheroboy on 11/7/2017.
 */
var AxisService = (function () {
    function AxisService() {
    }
    AxisService.prototype.drawAxis = function (canvasContext) {
        canvasContext.strokeStyle = '#d5d5d5;border;0.1px solid #5fee23';
        canvasContext.lineWidth = 0.25;
        canvasContext.backgroundColor = '#5fee23';
        var x = canvasContext.canvas.width;
        var y = canvasContext.canvas.height;
        canvasContext.setLineDash([]);
        canvasContext.beginPath();
        canvasContext.moveTo(0 + 0.5, (y / 2) + 0.5);
        canvasContext.lineTo(x + 0.5, (y / 2) + 0.5);
        canvasContext.stroke();
        canvasContext.closePath();
        canvasContext.beginPath();
        canvasContext.moveTo((x / 2) + 0.5, 0 + 0.5);
        canvasContext.lineTo((x / 2) + 0.5, y + 0.5);
        canvasContext.stroke();
        canvasContext.closePath();
        canvasContext.beginPath();
        canvasContext.moveTo(0, (y / 2) + 10.5);
        canvasContext.fillText(0, (x / 2) - 2, (y / 2) + 4);
        var xAxis = x / 2;
        var xAxisLeft = xAxis;
        var xAxisRight = xAxis;
        var yAxis = y / 2;
        var drawAxisLeft = 0;
        var drawAxisRight = 0;
        while (xAxisLeft >= 0 && xAxisRight < x) {
            xAxisLeft = xAxisLeft - 40;
            xAxisRight = xAxisRight + 40;
            canvasContext.fillText(--drawAxisLeft, xAxisLeft + 0.5, yAxis + 10.5);
            canvasContext.fillText(++drawAxisRight, xAxisRight + 0.5, yAxis + 10.5);
        }
        canvasContext.stroke();
        var sineV = 360;
        while (sineV > 0) {
            sineV = sineV - 20;
            canvasContext.moveTo(sineV + 5, 180);
            canvasContext.lineTo(sineV, 180);
        }
        sineV = 360;
        var sineVy = 0;
        while (sineV > 0) {
            sineV = sineV - 20;
            sineVy = 180.0 - Math.sin(sineV * Math.PI / 180) * 120;
            canvasContext.lineTo(sineV, sineVy);
        }
        canvasContext.moveTo(0, 180);
        canvasContext.stroke();
    };
    return AxisService;
}());
AxisService = __decorate([
    core_1.Injectable()
], AxisService);
exports.AxisService = AxisService;
//# sourceMappingURL=AxisService.js.map