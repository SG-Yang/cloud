import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {HttpService} from "./HttpService";
import {Formula} from "./Formula";
/**
 * Created by aheroboy on 11/7/2017.
 */

@Injectable()
export class FormulaService extends HttpService<Formula, Formula> {
  constructor(http: Http) {
    super(http);
    this.setComponent("saveFormula");
  }
}
