import {Component, OnInit} from "@angular/core";
import {HttpService} from "../../core/common/HttpService";
import {Res} from "../../Res";
import {Req} from "../../Req";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private httpService: HttpService<Req, Res>) {
  }

  ngOnInit(): void {
    let req: Req = new Req('get', {});
    this.httpService.setComponent('ahb/admin/dashboard');
    this.httpService.postItems(req);
  }
}
