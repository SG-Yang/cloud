import {Component, OnInit} from "@angular/core";
import {HttpService} from "../../../core/common/HttpService";
import {Domain} from "../../../core/common/domain";
import {PermissionGroup} from "../permission-group";
import {Permission} from "../../permission/permission";

@Component({
  selector: 'app-view-permission-group-details',
  templateUrl: './view-permission-group-details.component.html',
  styleUrls: ['./view-permission-group-details.component.css']
})
export class ViewPermissionGroupDetailsComponent implements OnInit {
  permissionGroup: PermissionGroup;
  searchDomain: Domain;
  msg: any;
  isLoaded:boolean;
  permissions: Permission[];

  constructor(private httpService: HttpService<any, any>) {
    this.permissionGroup = new PermissionGroup("a",'b');
  }

  ngOnInit() {
    this.httpService.setComponent("searchDomain").getItems("SECURITY_PEMISSION").subscribe(
      domain => {this.searchDomain = domain;this.isLoaded = true},
      error => this.msg = <any> error,
    );
  }

  onSubmit() {
    this.httpService.setComponent("search").postItems(this.searchDomain).subscribe(
      permissions => this.permissions = permissions,
      error => this.msg = <any> error
    );
    console.log(this.permissions);
  }
}
