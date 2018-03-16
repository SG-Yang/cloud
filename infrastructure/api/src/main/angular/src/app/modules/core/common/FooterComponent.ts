/**
 * Created by aheroboy on 15/6/2017.
 */
import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  template: `<footer class="w3-container w3-blue" style="position:fixed;left:0;width:100%;height:50px;
background:#000;bottom:0;z-index:9;"><h4>footer</h4>
  </footer>`,
})
export class FooterComponent { name = 'AppFooter'; }
