import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RestService} from "../rest.service";
import {Router} from "@angular/router";
import {NotifierService} from "angular-notifier";

@Component({
    selector: 'app-sign-up',
    templateUrl: './sign-up.page.html',
    styleUrls: ['./sign-up.page.scss'],
})
export class SignUpPage implements OnInit {

    private notifier: NotifierService;
    formSignUp: FormGroup;

    constructor(private restService: RestService,
                private formBuilder: FormBuilder,
                private notifierService: NotifierService,
                private router: Router) {

        this.notifier = notifierService;

        this.formSignUp = this.formBuilder.group(
            {
                'name' : [null, Validators.required],
                'surname' : [null, Validators.required],
                'email' : [null, Validators.required],
                'password' : [null, Validators.required]
            });
    }

    /* Registration Form */

    signUpRequest(){
        console.log("register new user");

        this.restService.post("signup", this.formSignUp.value)
            .subscribe(res => {
                    if (res.token != null){
                        console.log(res);
                        localStorage.setItem('token', res.token);
                        localStorage.setItem('id', res.id);
                        this.router.navigateByUrl(`/home`);
                    }
                    else{
                        this.notifier.notify( 'error', 'Email already in use! Please, retry.' );
                    }
                }, (err) => console.log(err)
            )
    }

    route(){

        this.router.navigateByUrl(`/login`);
    }

    ngOnInit() {
    }

}
