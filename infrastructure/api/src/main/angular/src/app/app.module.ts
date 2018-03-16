import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpModule, JsonpModule} from "@angular/http";

import {AppComponent} from "./app.component";
import {CoreModule} from "./modules/core/core.module";
import {RouterModule, Routes} from "@angular/router";
import {PageNotFoundComponent} from "./modules/core/common/PageNotFoundComponent";
import {LoginComponent} from "./modules/party/login/Login";


const routes: Routes = [
  {path: 'Login', component: LoginComponent, outlet: 'rootOutlet'},
  {path: 'Dashboard', component: PageNotFoundComponent, outlet: 'rootOutlet'},
  {path: 'Marketplace', component: PageNotFoundComponent, outlet: 'rootOutlet'},
];

@NgModule({
  imports: [BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    ReactiveFormsModule,
    CoreModule,
    RouterModule.forRoot(routes),
  ],
  declarations: [
    AppComponent
  ],
  bootstrap: [AppComponent]
})

export class AppModule {
}
