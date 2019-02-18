import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router, UrlSerializer} from '@angular/router';
import { RestService } from '../rest.service';

@Component({
    selector: 'app-event-list',
    templateUrl: './event-list.page.html',
    styleUrls: ['./event-list.page.scss'],
})
export class EventListPage implements OnInit {

    eventList : Array<any>;
    path: string

    constructor(private restService: RestService,
                private router: Router,
                private activatedroute: ActivatedRoute,
                private serializer: UrlSerializer) {

        this.activatedroute.queryParams.subscribe(params => {
                                                const tree = router.createUrlTree([], { queryParams:
                                                        {
                                                            title: params['title'],
                                                            locality: params['locality'],
                                                            categoryId:params['categoryId'],
                                                            date:params['date']
                                                        }
                                                });

                                                this.path = serializer.serialize(tree).replace("/event-list","")
        });
    }

    /* Get Event List */

    getEventListRequest(){

        console.log("get event list");

        this.restService.get("events" + this.path)
            .subscribe(data => {
                    console.log(data);
                    this.eventList = data["eventsList"]["eventElement"]
                }, (err) => console.log(err)
            )
    }

    route(id: string){

        this.router.navigateByUrl(`/event-detail/${id}`);
    }

    ngOnInit() {

        this.getEventListRequest();
    }

}
