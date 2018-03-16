/**
 * Created by aheroboy on 15/6/2017.
 */
import {Component, OnInit} from '@angular/core';
import {MenuService} from './MenuService';
import {MenuItem} from './MenuItem';
import {Params} from "./Params";

@Component({
  selector: 'app-nav',
  providers: [MenuService],
  template: `
    <nav class="w3-sidenav w3-border-green w3-animate-left" onmouseleave="w3_close()"><br>
      <a *ngFor="let item of items" [routerLink]="[{ outlets: {rootOutlet:[item.url]} }]"
         routerLinkActive="active">{{item.name}}</a>
    </nav>`,
})
export class NavBarComponent implements OnInit {
  items: MenuItem[];
  errorMessage: any;

  ngOnInit() {
    this.getMenuItems();
  }

  constructor(private  menuService: MenuService) {

  }

  getMenuItems() {
    let params = new Params();
    params.params = ["root", 1];
    this.menuService.getItems(params.toPathUrl())
      .subscribe(
        items => this.items = items,
        error => this.errorMessage = <any>error);
  }
}
