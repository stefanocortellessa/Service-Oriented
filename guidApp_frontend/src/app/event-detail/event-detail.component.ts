/// <reference types="@types/googlemaps" />

import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { LoadingController } from '@ionic/angular';
import { RestService } from '../rest.service';

declare var google;

@Component({
    selector: 'app-event-detail',
    templateUrl: './event-detail.component.html',
    styleUrls: ['./event-detail.component.scss']
})
export class EventDetailComponent implements OnInit {

    @ViewChild('map') mapElement: ElementRef;
    map: any;
    address:string;

    eventId : string;
    eventDetail : any;

    constructor(private router: Router,
                private activatedRoute: ActivatedRoute,
                private restService: RestService,
                public loadingController: LoadingController
                ) { }

    /* Get Event Detail */

    loadMap() {

            let latLng = new google.maps.LatLng(this.eventDetail.lat, this.eventDetail.lng);

            let mapOptions = {
                center: latLng,
                zoom: 15,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            }

            this.map = new google.maps.Map(this.mapElement.nativeElement, mapOptions);

            var marker = new google.maps.Marker({
                position: latLng,
                map: this.map,
                title: 'Here!'
            });

            marker.setMap(this.map);
    }

    async getEventDetailRequest() {

        console.log("get event detail");
        const loading = await this.loadingController.create({
            message: 'Loading'
        });
        await loading.present();
        await this.restService.get("events/" + this.eventId)
            .subscribe(data => {
                console.log(data["eventElement"]);
                this.eventDetail = data["eventElement"];
                loading.dismiss();
            }, err => {
                console.log(err);
                loading.dismiss();
            });
    }

    ngOnInit() {

        this.eventId = this.activatedRoute.snapshot.paramMap.get("id");
        this.getEventDetailRequest();
        this.loadMap()
    }

}
