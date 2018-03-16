/**
 * Created by aheroboy on 15/6/2017.
 */
import {Component, OnInit} from "@angular/core";
import {PermissionSearchItem} from "../../core/common/PermissionSearchItem";
import {PermissionHttpService} from "./PermissionService";
import {HttpService} from "../../core/common/HttpService";
import {Permission} from "./permission";


@Component({
  selector: 'user-permission',
  providers: [PermissionHttpService],
  template: `
    <div class="w3-container">
      <top-nav></top-nav>
    </div>
    <router-outlet name="pOutlet"></router-outlet>
  `,
})
export class UserPermissionComponent implements OnInit {
  searchItems: PermissionSearchItem[];
  errorMessage: any;

  constructor(private searchService: PermissionHttpService) {

  }

  ngOnInit(): void {
    this.searchService.getItems("SECURITY_PEMISSION").subscribe(
      items => this.searchItems = items,
      error => this.errorMessage = <any>error);
    ;
  }
}


