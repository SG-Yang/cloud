import {Injectable} from "@angular/core";
import {HttpService} from "../../core/common/HttpService";
import {User} from "./User";
import {Http} from "@angular/http";
/**
 * Created by aheroboy on 5/11/2017.
 */
@Injectable()
export class UserLoginService extends HttpService<User,User> {
    constructor(http: Http) {
        super(http);
        this.setComponent("ahb/pub/login");
    }
}
