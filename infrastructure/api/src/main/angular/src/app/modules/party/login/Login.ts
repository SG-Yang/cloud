/**
 * Created by aheroboy on 4/11/2017.
 */

import {Component} from "@angular/core";
import {User} from "./User";
import {HttpService} from "../../core/common/HttpService";
import {UserLoginService} from "./UserLoginService";
import {Headers, RequestOptions} from "@angular/http";
import {Req} from "../../Req";
import {Res} from "../../Res";
import {Router} from "@angular/router";
@Component({
  selector: 'login-form',
  templateUrl: './userForm.html',
  providers: [HttpService, UserLoginService]
})
export class LoginComponent {
  name = "LoginComponent"
  loginUser = new User(0, 'ysg', 'heping');
  submitted = false;

  constructor(private userService: UserLoginService, private route: Router) {

  }

  doLogin() {
    this.submitted = true;
    let headers = new Headers({
        'Authorization': 'Basic' + btoa(this.loginUser.username + ':' + this.loginUser.password),
        'X-Requested-With': 'XMLHttpRequest',
        'Content-Type': 'application/json'
      }
    );
    this.userService.login(new Req("LOGIN", this.loginUser), new RequestOptions({headers: headers})).subscribe(outUser => {
      let res = outUser as Res;
      if (res && res.status) {
        console.error("invalid login...")
        this.route.navigateByUrl('/(rootOutlet:Dashboard)');
      } else {
        console.info("Login success!!!")
      }
    });
  }

  get diagnostic() {
    return JSON.stringify(this.loginUser);
  }
}
