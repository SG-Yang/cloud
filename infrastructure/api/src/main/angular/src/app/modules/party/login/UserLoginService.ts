import {Injectable} from "@angular/core";
import {HttpService} from "../../core/common/HttpService";
import {Http} from "@angular/http";
import {Req} from "../../Req";
import {Res} from "../../Res";
/**
 * Created by aheroboy on 5/11/2017.
 */
@Injectable()
export class UserLoginService extends HttpService<Req,Res> {
    constructor(http: Http) {
        super(http);

        this.setComponent("ahb/pub_region/user");
    }
}
