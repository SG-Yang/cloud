import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {RouterModule} from "@angular/router";
import {ModifyPermissionComponent} from "./permission/modify-permission/modify-permission.component";
import {AddPermissionComponent} from "./permission/add-permission/add-permission.component";
import {TopBarComponent} from "./permission/TopBarComponent";
import {UserPermissionComponent} from "./permission/UserPermissionComponent";
import {FormsModule} from "@angular/forms";
import {PermissionAddService} from "./permission/PermissionAddService";
import {ViewPermissionComponent} from "./permission/view-permission/view-permission.component";
import {FindPermissionComponent} from "./permission/find-permission/find-permission.component";
import {HttpService} from "../core/common/HttpService";
import {PermissionComponent} from "./permission/permission.component";
import {PermissionGroupComponent} from "./permission-group/permission-group.component";
import {UserAuthorizationComponent} from "./user-authorization/user-authorization.component";
import {AddPermissionGroupComponent} from "./permission-group/add-permission-group/add-permission-group.component";
import {AppTopNavComponent} from "./permission-group/AppTopNavComponent";
import {LinkPermissionGroupComponent} from "./permission-group/link-permission-group/link-permission-group.component";
import { PermissionGroupLinkageComponent } from './permission-group/permission-group-linkage/permission-group-linkage.component';
import { ViewPermissionGroupDetailsComponent } from './permission-group/view-permission-group-details/view-permission-group-details.component';
import {
  MatButtonModule, MatCheckboxModule, MatDatepicker, MatDatepickerModule, MatDatepickerToggle,
  MatInputModule
} from "@angular/material";

@NgModule({
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatInputModule,
    MatDatepickerModule
  ],
  declarations: [
    ModifyPermissionComponent,
    TopBarComponent,
    AddPermissionComponent,
    UserPermissionComponent,
    ViewPermissionComponent,
    FindPermissionComponent,
    PermissionComponent,
    PermissionGroupComponent,
    UserAuthorizationComponent,
    AddPermissionGroupComponent,
    AppTopNavComponent,
    LinkPermissionGroupComponent,
    PermissionGroupLinkageComponent,
    ViewPermissionGroupDetailsComponent,
  ],
  providers: [
    ModifyPermissionComponent,
    TopBarComponent,
    AddPermissionComponent,
    UserPermissionComponent,
    PermissionAddService,
    HttpService,
    MatDatepicker,
    MatDatepickerToggle
  ],
  exports: [
    ModifyPermissionComponent,
    TopBarComponent,
    RouterModule,
    AddPermissionComponent,
    ModifyPermissionComponent,
    TopBarComponent,
    AddPermissionComponent,
    ViewPermissionComponent,
    FindPermissionComponent,
    PermissionComponent,
    PermissionGroupComponent,
    UserAuthorizationComponent,
    AddPermissionGroupComponent,
    AppTopNavComponent,
    LinkPermissionGroupComponent,
  ]
})
export class PermissionModule {
}
