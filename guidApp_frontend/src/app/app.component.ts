import { Component } from '@angular/core';

import { Platform } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import {RestService} from "./rest.service";
import {NavigationEnd, Router} from "@angular/router";
import {SessionCheckerService} from "./session-checker.service";

@Component({
    selector: 'app-root',
    templateUrl: 'app.component.html'
})
export class AppComponent {
    public appPages = [
        {
            title: 'Home',
            url: '/home',
            icon: 'home'
        },
        {
            title: 'Create Event',
            url: '/create-event',
            icon: 'create'
        },
        {
            title: 'Create Attraction',
            url: '/create-attraction',
            icon: 'create'
        },
        {
            title: 'Search Events',
            url: '/event-search',
            icon: 'search'
        },
        {
            title: 'Search Attractions',
            url: '/attraction-search',
            icon: 'search'
        }
    ];

    public appNotLoggedPages = [
        {
            title: 'Home',
            url: '/home',
            icon: 'home'
        },
        {
            title: 'Search Events',
            url: '/event-search',
            icon: 'search'
        },
        {
            title: 'Search Attractions',
            url: '/attraction-search',
            icon: 'search'
        },
        {
            title: 'Register',
            url: '/sign-up',
            icon: 'create'
        },
        {
            title: 'Log In',
            url: '/login',
            icon: 'log-in'
        }
    ];

    logged: boolean;

    constructor(
        private platform: Platform,
        private splashScreen: SplashScreen,
        private statusBar: StatusBar,
        private restService: RestService,
        private router: Router,
        private sessionChecker: SessionCheckerService,

    ) {
        this.initializeApp();
        router.events.subscribe((val) => {
            // see also
            if(val instanceof NavigationEnd){
                this.logged = this.sessionChecker.loggedIn()
            }
        });
    }

    /* Logout Form */
    logoutRequest(){

        console.log("logout");

        this.restService.delete("logout/" + localStorage.getItem('token'))
            .subscribe(res => {
                    localStorage.removeItem('token');
                    localStorage.removeItem('id');
                    this.router.navigateByUrl(`/login`);
                }, (err) => console.log(err)
            )
    }

    initializeApp() {
        this.platform.ready().then(() => {
            this.statusBar.styleDefault();
            this.splashScreen.hide();
        });
    }
}
