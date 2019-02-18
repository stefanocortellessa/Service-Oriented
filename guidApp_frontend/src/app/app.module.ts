import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from  '@angular/common/http';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { Geolocation } from '@ionic-native/geolocation/ngx';
import { NativeGeocoder } from '@ionic-native/native-geocoder/ngx';
import { NotifierModule } from 'angular-notifier';

/* Services*/
import { RestService } from './rest.service';
import {SessionCheckerService} from "./session-checker.service";
import { EventDetailComponent } from './event-detail/event-detail.component';
import { AttractionDetailComponent } from './attraction-detail/attraction-detail.component';

@NgModule({
    declarations: [
        AppComponent,
        EventDetailComponent,
        AttractionDetailComponent
    ],
    entryComponents: [
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        IonicModule.forRoot(),
        AppRoutingModule,
        NotifierModule
    ],
    providers: [
        StatusBar,
        SplashScreen,
        Geolocation,
        NativeGeocoder,
        SessionCheckerService,
        RestService,
        {
            provide: RouteReuseStrategy,
            useClass: IonicRouteStrategy
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: SessionCheckerService,
            multi: true
        }
    ],
    bootstrap: [AppComponent]
})
export class AppModule {}

