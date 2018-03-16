/**
 * Created by aheroboy on 15/6/2017.
 */
import {Component} from '@angular/core';
import {} from '@angular/material'

@Component({
  selector: 'app-sources',
  template: `
      <div style="margin-top: 20px; border: 10px; border-color: #00acc1">
         <label>Source Management</label> 
          <div>
              <table border="1px;solid">
                  <tr>
                      <td><label>SourceType:</label></td>
                      <td>
                      </td>
                  </tr>
              </table>
          </div>
      </div>
    `,
})
export class SourceComponent {
    foods = [
        {value: 'steak-0', viewValue: 'Steak'},
        {value: 'pizza-1', viewValue: 'Pizza'},
        {value: 'tacos-2', viewValue: 'Tacos'}
    ];
}
