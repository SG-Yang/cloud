import {Component, Input, OnInit} from '@angular/core';
import {PermissionGroup} from "../permission-group";

@Component({
  selector: 'app-permission-group-linkage',
  templateUrl: './permission-group-linkage.component.html',
  styleUrls: ['./permission-group-linkage.component.css']
})
export class PermissionGroupLinkageComponent implements OnInit {
  @Input() groups :PermissionGroup[]

  constructor() { }

  ngOnInit() {
  }

  openPermissionGroup(targetId: number){
    console.log("target Id:" + targetId);
  }

}
