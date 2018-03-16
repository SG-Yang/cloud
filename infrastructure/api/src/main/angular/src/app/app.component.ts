import {Component} from "@angular/core";

@Component({
  selector: 'app-root',
  template: `
    <div style="width: 99%;height: 90%;margin-right: -1%;">
      <app-header></app-header>
      <div style="margin-top:10%">
        <!--<app-nav></app-nav>-->
        <div id="main">
          <router-outlet name="rootOutlet"></router-outlet>
        </div>

      </div>
      <app-footer></app-footer>
    </div>`,

})

export class AppComponent {
  name = 'Angular';
}
