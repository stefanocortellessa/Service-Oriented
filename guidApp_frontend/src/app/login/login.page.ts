import { Component, OnInit } from '@angular/core';
import {RestService} from "../rest.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {NotifierService} from "angular-notifier";


@Component({
    selector: 'app-login',
    templateUrl: './login.page.html',
    styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

    private notifier: NotifierService;
    formLogin: FormGroup;

    constructor(private restService: RestService,
                private formBuilder: FormBuilder,
                private notifierService: NotifierService,
                private router: Router) {

        this.notifier = notifierService;

        this.formLogin = this.formBuilder.group(
            {
                'email' : [null, Validators.required],
                'password' : [null, Validators.required]
            });
    }

    /* Login Form */
    loginRequest(){

        console.log("login");
        console.log(this.formLogin.value);

        this.restService.post("login", this.formLogin.getRawValue())
            .subscribe(res => {
                    if (res.token != null){
                        localStorage.setItem('token', res.token);
                        localStorage.setItem('id', res.id);
                        this.router.navigateByUrl(`/home`);
                    }
                    else{
                        this.notifier.notify( 'error', 'Invalid Email or Password! Please, retry.' );
                    }
                }, (err) => {
                    console.log(err);
                }
            );
    }

    route(){

        this.router.navigateByUrl(`/sign-up`);
    }

    ngOnInit() {
    }

}
