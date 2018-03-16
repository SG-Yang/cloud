import {NgModule} from "@angular/core";
import {NavBarComponent} from "./common/NavBarComponent";
import {FooterComponent} from "./common/FooterComponent";
import {HeaderComponent} from "./common/HeaderComponent";
import {LoginComponent} from "../party/login/Login";
import {PageNotFoundComponent} from "./common/PageNotFoundComponent";
import {MainComponent} from "./common/MainComponent";
import {SourceComponent} from "./common/SourceComponent";
import {PermissionHttpService} from "../permission/permission/PermissionService";
import {MenuService} from "./common/MenuService";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {BrowserModule} from "@angular/platform-browser";


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
    NavBarComponent
  ],
  providers: [
    MenuService,
    PermissionHttpService,
    SourceComponent,
    MainComponent,
    PageNotFoundComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    NavBarComponent
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
