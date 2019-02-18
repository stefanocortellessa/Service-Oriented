import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router, UrlSerializer} from '@angular/router';
import { RestService } from '../rest.service';

@Component({
    selector: 'app-attraction-list',
    templateUrl: './attraction-list.page.html',
    styleUrls: ['./attraction-list.page.scss'],
})
export class AttractionListPage implements OnInit {

    attractionList : Array<any>;
    path: string

    constructor(private restService: RestService,
                private router: Router,
                private activatedroute: ActivatedRoute,
                private serializer: UrlSerializer) {

        this.activatedroute.queryParams.subscribe(params => {
                                                const tree = router.createUrlTree([], { queryParams:
                                                        {
                                                            name: params['name'],
                                                            locality: params['locality'],
                                                            categoryId:params['categoryId']
                                                        }
                                                });

                                                this.path = serializer.serialize(tree).replace("/attraction-list","")
            console.log(this.path)
        });
    }

    /* Get Event List */

    getAttractionListRequest(){

        console.log("get attraction list");

        this.restService.get("attractions" + this.path)
            .subscribe(data => {
                    console.log(data);
                    console.log(data["attractionsList"]);
                    console.log(data["attractionsList"]["attractionElement"]);
                    this.attractionList = data["attractionsList"]["attractionElement"]
                }, (err) => console.log(err)
            )
    }

    route(id: string){

        this.router.navigateByUrl(`/attraction-detail/${id}`);
    }

    ngOnInit() {
        this.getAttractionListRequest();
    }

}
