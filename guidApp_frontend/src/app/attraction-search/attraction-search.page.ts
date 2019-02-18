import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RestService} from "../rest.service";

@Component({
    selector: 'app-attraction-search',
    templateUrl: './attraction-search.page.html',
    styleUrls: ['./attraction-search.page.scss'],
})
export class AttractionSearchPage implements OnInit {

    formAttractionSearch: FormGroup;
    categoriesList: any;

    constructor(private restService: RestService,
                private formBuilder: FormBuilder,
                private route : ActivatedRoute,
                private router: Router,) {

        this.formAttractionSearch = this.formBuilder.group(
            {
                'name' : [null, Validators],
                'locality' : [null, Validators],
                'categoryId' : [null, Validators],
            });
    }

    /* Search Attractions Form */

    getAttractionsRequest(){

        this.router.navigate(['/attraction-list'], { queryParams: this.formAttractionSearch.value });
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
