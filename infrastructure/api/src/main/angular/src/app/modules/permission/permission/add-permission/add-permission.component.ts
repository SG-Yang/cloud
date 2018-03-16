import {Component, OnInit} from "@angular/core";
import {Permission} from "../permission";
import {PermissionAddService} from "../PermissionAddService";

@Component({
  selector: 'app-add-permission',
  templateUrl: './add-permission.component.html',
})
export class AddPermissionComponent implements OnInit {
  permission: Permission;
  msg = "working on....";

  constructor(private permissionService: PermissionAddService) {
    this.permission = new Permission("ADMIN_FULLL", "Admin full control");
  }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.msg = this.permission.code + '|' + this.permission.desc);
    this.permissionService.postItems(this.permission).subscribe(
      permissionObj => this.permission = permissionObj,
      error => this.msg= <any>error
    );
  }

}
