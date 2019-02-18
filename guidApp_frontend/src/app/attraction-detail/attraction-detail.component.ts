import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { LoadingController } from '@ionic/angular';
import { RestService } from '../rest.service';

@Component({
    selector: 'app-attraction-detail',
    templateUrl: './attraction-detail.component.html',
    styleUrls: ['./attraction-detail.component.scss']
})
export class AttractionDetailComponent implements OnInit {

    attractionId : string;
    attractionDetail : any;

    constructor(private router: Router,
                private activatedRoute: ActivatedRoute,
                private restService: RestService,
                public loadingController: LoadingController
    ) {

        this.attractionId = activatedRoute.snapshot.url[activatedRoute.snapshot.url.length-1].path;
    }

    /* Get Event Detail */

    maps() {

        console.log("MOSTRA MAPPE");
    }

    async getAttractionDetailRequest() {

        console.log("get event detail");
        const loading = await this.loadingController.create({
            message: 'Loading'
        });
        await loading.present();
        await this.restService.get("attractions/" + this.attractionId)
            .subscribe(data => {
                console.log(data["attractionElement"]);
                this.attractionDetail = data["attractionElement"]
                loading.dismiss();
            }, err => {
                console.log(err);
                loading.dismiss();
            });
    }

    ngOnInit() {

        this.getAttractionDetailRequest()
    }

}
