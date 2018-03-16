/**
 * Created by aheroboy on 15/6/2017.
 */
import {Component, OnInit} from "@angular/core";
import {MenuService} from "../../core/common/MenuService";
import {MenuItem} from "../../core/common/MenuItem";
import {Params} from "../../core/common/Params";


@Component({
  selector: 'app-top-nav',
  providers: [MenuService],
  template: `
    <nav class="w3-topnav w3-dark-grey w3-border-black w3-animate-left">
      <br>
      <a *ngFor="let item of items" [routerLink]="[{ outlets: {pGrpOutlet:[item.url]} }]">{{item.name}}</a>
    </nav>`,
})
export class AppTopNavComponent implements OnInit {
  items: MenuItem[];
  errorMessage: any;

  ngOnInit() {
    this.getMenuItems();
  }

  constructor(private  menuService: MenuService) {

  }

  getMenuItems() {
    let params = new Params();
    params.params = ["permission_group", 2];
    this.menuService.getItems(params.toPathUrl())
      .subscribe(
        items => this.items = items,
        error => this.errorMessage = <any>error);
  }
}
