import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RestService} from "../rest.service";
import {NotifierService} from "angular-notifier";

@Component({
    selector: 'app-create-attraction',
    templateUrl: './create-attraction.page.html',
    styleUrls: ['./create-attraction.page.scss'],
})
export class CreateAttractionPage implements OnInit {

    private notifier: NotifierService;
    formAttraction: FormGroup;
    categoriesList: any;

    constructor(private restService: RestService,
                private formBuilder: FormBuilder,
                private notifierService: NotifierService,
                private route : ActivatedRoute,
                private router: Router) {

        this.notifier = notifierService;

        this.formAttraction = this.formBuilder.group(
            {
                'name' : [null, Validators.required],
                'locality' : [null, Validators.required],
                'category' : [null, Validators.required],
                'creator' : {
                                "id": localStorage.getItem('id')
                            },
            });
    }

    /* Create Attraction Form */

    saveAttractionRequest(){

        console.log("insert attraction");

        for(let row of this.categoriesList) {
            if (row["id"] == this.formAttraction.value["category"]) {
                this.formAttraction.value["category"] = row;
            }
        }

        console.log(this.formAttraction.value);

        this.restService.post("attractions", this.formAttraction.value)
            .subscribe(res => {
                    console.log(res);
                    this.notifier.notify( 'success', 'Attraction correctly created!' );
                }, (err) => {
                                    console.log(err);
                                    this.notifier.notify( 'error', 'Invalid Locality! Please, retry.' );
                    }
            )
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
