/**
 * Created by aheroboy on 17/6/2017.
 */

import {Injectable} from "@angular/core";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import {MenuItem} from "./MenuItem";
import {HttpService} from "./HttpService";
import {Http} from "@angular/http";

@Injectable()
export class MenuService extends HttpService<MenuItem[], MenuItem[]> {
  constructor(http: Http) {
    super(http);
    this.setComponent("sys/nav");
  }

  /**
   evalFormula(type: string, formula: Formula ): Observable<Formula> {
    return this.http.post(this.menuUrl + type, formula)
        .map(this.extractData)
        .catch(this.handleError);
  }
   **/

}
