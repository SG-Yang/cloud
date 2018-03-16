import {Http} from "@angular/http";
import {HttpService} from "../../core/common/HttpService";
import {Injectable} from "@angular/core";
import {Permission} from "./permission";
/**
 * Created by aheroboy on 12/11/2017.
 */
@Injectable()
export class PermissionAddService extends HttpService<Permission, Permission> {
  constructor(http: Http) {
    super(http);
    this.setComponent("user/permission/add");
  }

}
