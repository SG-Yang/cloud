import {NgModule} from "@angular/core";
import {NavBarComponent} from "./common/NavBarComponent";
import {FooterComponent} from "./common/FooterComponent";
import {HeaderComponent} from "./common/HeaderComponent";
import {LoginComponent} from "../party/login/Login";
import {PageNotFoundComponent} from "./common/PageNotFoundComponent";
import {MainComponent} from "./common/MainComponent";
import {SourceComponent} from "./common/SourceComponent";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {BrowserModule} from "@angular/platform-browser";
import {DashboardComponent} from "../party/dashboard/dashboard.component";
import {HttpService} from "./common/HttpService";
import { ColumnLayoutComponent } from './common/layout/column-layout/column-layout.component';
import { RowLayoutComponent } from './common/layout/row-layout/row-layout.component';
import { CardLayoutComponent } from './common/layout/card-layout/card-layout.component';
import { FlowLayoutComponent } from './common/layout/flow-layout/flow-layout.component';
import { GridBagLayoutComponent } from './common/layout/grid-bag-layout/grid-bag-layout.component';
import { GridLayoutComponent } from './common/layout/grid-layout/grid-layout.component';
import { GroupLayoutComponent } from './common/layout/group-layout/group-layout.component';
import { BoxLayoutComponent } from './common/layout/box-layout/box-layout.component';
import { SpringLayoutComponent } from './common/layout/spring-layout/spring-layout.component';
import { BorderLayoutComponent } from './common/layout/border-layout/border-layout.component';
import { ViewManagerComponent } from './common/view-manager/view-manager.component';


@NgModule({
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
    SourceComponent,
    MainComponent,
    PageNotFoundComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    NavBarComponent,
    DashboardComponent,
    ColumnLayoutComponent,
    RowLayoutComponent,
    CardLayoutComponent,
    FlowLayoutComponent,
    GridBagLayoutComponent,
    GridLayoutComponent,
    GroupLayoutComponent,
    BoxLayoutComponent,
    SpringLayoutComponent,
    BorderLayoutComponent,
    ViewManagerComponent
  ],
  providers: [
    HttpService
  ],

  exports: [
    SourceComponent,
    MainComponent,
    PageNotFoundComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    NavBarComponent
  ]

})
export class CoreModule {
  name = "CoreModule"
}
