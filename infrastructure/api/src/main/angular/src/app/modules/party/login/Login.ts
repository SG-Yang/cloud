/**
 * Created by aheroboy on 4/11/2017.
 */

import {Component} from "@angular/core";
import {User} from "./User";
import {HttpService} from "../../core/common/HttpService";
import {UserLoginService} from "./UserLoginService";
import {RequestOptions,Headers} from "@angular/http";
@Component({
    selector: 'login-form',
    templateUrl: './userForm.html',
    providers :[HttpService,UserLoginService]
})
export class LoginComponent {
    name = "LoginComponent"
    model = new User(0, 'sg', 'yang');
    submitted = false;

    constructor(private userService: UserLoginService){

    }
   onSubmit() {
        this.submitted = true;
        let headers = new Headers({
          'Authorization': 'Basic' + btoa(this.model.username + ':' + this.model.password),
          'X-Requested-With' : 'XMLHttpRequest',
          'Content-Type':'application/json'}
        );
        this.userService.login(this.model,new RequestOptions({headers: headers})).subscribe(outUser => {
            this.model = outUser as User;
        } );
    }

    get diagnostic() {
        return JSON.stringify(this.model);
    }
}
