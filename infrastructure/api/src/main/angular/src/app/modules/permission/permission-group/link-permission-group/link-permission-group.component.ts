import {Component, OnInit} from "@angular/core";
import {PermissionGroup} from "../permission-group";
import {HttpService} from "../../../core/common/HttpService";

@Component({
  selector: 'app-link-permission-group',
  templateUrl: './link-permission-group.component.html',
  styleUrls: ['./link-permission-group.component.css']
})
export class LinkPermissionGroupComponent implements OnInit {
  permissionGroup: PermissionGroup;
  permissionGroups: PermissionGroup[];
  msg: any;

  constructor(private httpService: HttpService<PermissionGroup, PermissionGroup[]>) {
  }

  ngOnInit() {
    this.permissionGroup = new PermissionGroup("Code", "desc");
  }

  onSubmit() {
    this.httpService.setComponent("user/permissionGroup/findGroups")
    this.httpService.postItems(this.permissionGroup).subscribe(
      groups => this.permissionGroups = groups,
      error => this.msg = <any> error
    );
  }
}
