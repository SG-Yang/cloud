import {Component, OnInit} from "@angular/core";
import {PermissionGroup} from "../permission-group";
import {HttpService} from "../../../core/common/HttpService";

@Component({
  selector: 'app-add-permission-group',
  templateUrl: './add-permission-group.component.html',
  styleUrls: ['./add-permission-group.component.css'],
})
export class AddPermissionGroupComponent implements OnInit {
  permissionGroup: PermissionGroup;
  msg: any;

  constructor(private httpService: HttpService<PermissionGroup, PermissionGroup>) {
  }

  ngOnInit() {
    this.permissionGroup = new PermissionGroup("PG", "Permission Group1");
  }

  onSubmit() {
    console.log(this.permissionGroup);
    this.httpService.setComponent("/user/permissionGroup/addGroup")
    this.httpService.postItems(this.permissionGroup).subscribe(
      group => this.permissionGroup = group,
      message => this.msg = <any>message
    );
  }
}
