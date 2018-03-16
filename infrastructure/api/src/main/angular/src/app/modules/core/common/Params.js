"use strict";
/**
 * Created by aheroboy on 25/7/2017.
 */
var Params = (function () {
    function Params() {
    }
    Params.prototype.toPathUrl = function () {
        var pathUrl;
        for (var p in this.params) {
            if (pathUrl) {
                pathUrl = pathUrl + "/" + this.params[p];
            }
            else {
                pathUrl = this.params[p];
            }
            console.log(pathUrl);
        }
        return pathUrl;
    };
    return Params;
}());
exports.Params = Params;
//# sourceMappingURL=Params.js.map