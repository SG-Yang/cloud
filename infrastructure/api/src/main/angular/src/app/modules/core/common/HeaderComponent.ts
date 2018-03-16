/**
 * Created by aheroboy on 15/6/2017.
 */
import {Component} from '@angular/core';

@Component({
  selector: 'app-header',
  template: `
    <header class="w3-top w3-border-dark-grey w3-card-24 w3-blue w3-large w3-padding ">
      <div style="z-index:4">
        <div class="w3-left">
          <span class="w3-opennav w3-xlarge" onmouseover="w3_open()">&#9776;</span>
          <span class="w3-right">&nbsp;&nbsp;Logo</span>
        </div>
        <ul class="w3-navbar w3-right">
          <li><a [routerLink]='[{ outlets: {rootOutlet:["Dashboard"]} }]'><span>Dashboard</span></a></li>
          <li><a [routerLink]='[{ outlets: {rootOutlet:["Marketplace"]} }]'><span>Marketplace</span></a></li>
          <li><a [routerLink]='[{ outlets: {rootOutlet:["Login"]} }]'><span>Login</span></a></li>
        </ul>
      </div>
    </header>`,
})
export class HeaderComponent {
  name = 'HeaderComponent';


}
