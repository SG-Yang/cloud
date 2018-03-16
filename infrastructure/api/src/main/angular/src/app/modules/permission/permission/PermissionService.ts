import {Http} from "@angular/http";
import {PermissionSearchItem} from "../../core/common/PermissionSearchItem";
import {HttpService} from "../../core/common/HttpService";
import {Injectable} from "@angular/core";
/**
 * Created by aheroboy on 12/11/2017.
 */
@Injectable()
export class PermissionHttpService extends HttpService<PermissionSearchItem[],PermissionSearchItem[]>{
  constructor(http: Http){
    super(http);
    this.setComponent("searchItems");
  }
}
