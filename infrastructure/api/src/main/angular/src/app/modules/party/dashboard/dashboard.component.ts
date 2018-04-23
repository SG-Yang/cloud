import {Component, OnInit} from "@angular/core";
import {HttpService} from "../../core/common/HttpService";
import {Res} from "../../Res";
import {Req} from "../../Req";
import {CriteriaImpl} from "../../CriteriaImpl";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  component: string = "ahb/admin/dashboard";
  commandComponent:string = "ahb/admin/command";

  constructor(private httpService: HttpService<Req, Res>) {
  }

  result: Res;

  shouldRequest(value: string): any {
    return value.lastIndexOf(".") + 1 == value.length;
  }

  editPage(value: string): any {
    if (this.shouldRequest(value)) {
      console.info(value);
      let req = new Req('EDIT', new CriteriaImpl(value,"PROPOSAL"));
      this.httpService.postItemsProvideComponent(req, this.commandComponent).subscribe(
        result => {
          let res = result as Res;
          if (res && res.status) {
            this.result = res;
            console.info("result is:" + this.result);
          } else {
            console.error("Invalid access.");
          }
        }
      );
    }
  }

  getInterClass(): any {
    if (this.result) {
      return this.result.view.style.classId;
    } else {
      return "w3-container";
    }
  }

  ngOnInit(): void {
    let req: Req = new Req('VIEW', new CriteriaImpl("some else","PROPOSAL"));
    this.httpService.postItemsProvideComponent(req,this.component).subscribe(dashboard => {
      let res = dashboard as Res;
      if (res && res.status) {
        this.result = res;
        console.info("result is:" + this.result);
      } else {
        console.error("Invalid access.");
      }
    });
    console.info("dashboard success!!!")
  }
}
