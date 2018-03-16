import {HttpService} from "./HttpService";
import {Types} from "./Types";
import {Http} from "@angular/http";
import {Injectable} from "@angular/core";
/**
 *
 * Created by aheroboy on 25/7/2017.
 */
@Injectable()
export class TypeService extends HttpService<Types[],Types[]>{
    constructor(http: Http) {
        super(http);
        this.setComponent("ref");
    }
}
