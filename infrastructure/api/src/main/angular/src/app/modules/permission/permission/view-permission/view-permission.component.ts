import {Component, Input, OnInit} from '@angular/core';
import {Permission} from "../permission";
import {HttpService} from "../../../core/common/HttpService";

@Component({
  selector: 'app-view-permission',
  templateUrl: './view-permission.component.html',
  styleUrls: ['./view-permission.component.css'],
  providers:[HttpService]
})
export class ViewPermissionComponent implements OnInit {
  @Input() permissions: Permission[];
  constructor() { }

  ngOnInit() {
  }

}
