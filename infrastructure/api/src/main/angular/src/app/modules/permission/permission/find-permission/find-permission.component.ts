import {Component, OnInit, Output} from "@angular/core";
import {PermissionHttpService} from "../PermissionService";
import {PermissionSearchItem} from "../../../core/common/PermissionSearchItem";
import {Permission} from "../permission";
import {HttpService} from "../../../core/common/HttpService";

@Component({
  selector: 'app-find-permission',
  templateUrl: './find-permission.component.html',
  styleUrls: ['./find-permission.component.css']
})
export class FindPermissionComponent implements OnInit {
  criteras: PermissionSearchItem[];
  msg: any;
  permissions: Permission[];

  constructor(private permissionService: PermissionHttpService, private httpService: HttpService<PermissionSearchItem[], Permission[]>) {
  }

  ngOnInit() {
    this.permissionService.getItems("SECURITY_PEMISSION").subscribe(
      queryCritera => this.criteras = queryCritera,
      error => this.msg = <any>error
    );
  }

  onSubmit() {
    for (let i of this.criteras) {
      console.log(i);
    }
    this.httpService.setComponent("user/permission/searchItems");
    //this.httpService.setHttp(this.permissionService.getHttp());
    this.httpService.postItems(this.criteras).subscribe(
      queries => this.permissions = queries,
      error => this.msg = <any> error
    );
  }

}
