import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { RestService } from "../rest.service";

@Component({
    selector: 'app-event-search',
    templateUrl: './event-search.page.html',
    styleUrls: ['./event-search.page.scss'],
})
export class EventSearchPage implements OnInit {

    formEventSearch: FormGroup;
    categoriesList: any;

    constructor(private restService: RestService,
                private formBuilder: FormBuilder,
                private route : ActivatedRoute,
                private router: Router,
                ) {

        this.formEventSearch = this.formBuilder.group(
            {
                'title' : [null, Validators],
                'locality' : [null, Validators],
                'date' : [null, Validators],
                'categoryId' : [null, Validators],
            });
    }

    /* Search Events Form */

    getEventsRequest(){
        if(this.formEventSearch.value['date'] != null){

            this.formEventSearch.value['date'] = this.formEventSearch.value['date'] + ":01:00:00";
        }

        this.router.navigate(['/event-list'], { queryParams: this.formEventSearch.value });
    }

    getCategoriesListRequest(){

        console.log("get categories list");

        this.restService.get("categories")
            .subscribe(data => {
                    console.log(data);
                    this.categoriesList = data["categoryList"]["categoryElement"]
                }, (err) => console.log(err)
            )
    }

    ngOnInit() {

        this.getCategoriesListRequest()
    }

}
