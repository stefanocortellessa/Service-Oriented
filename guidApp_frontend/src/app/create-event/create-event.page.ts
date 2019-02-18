import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router} from '@angular/router';
import { FormsModule, FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { NotifierService } from 'angular-notifier';
import "angular-notifier/styles.scss"
import { RestService } from '../rest.service';

@Component({
    selector: 'app-create-event',
    templateUrl: './create-event.page.html',
    styleUrls: ['./create-event.page.scss'],
})
export class CreateEventPage implements OnInit {

    private notifier: NotifierService;
    formEvent: FormGroup;
    categoriesList: any;

    constructor(private restService: RestService,
                private formBuilder: FormBuilder,
                private notifierService: NotifierService,
                private route : ActivatedRoute,
                private router: Router) {

        this.notifier = notifierService;

        this.formEvent = this.formBuilder.group(
            {
                'title' : [null, Validators.required],
                'locality' : [null, Validators.required],
                'startDate' : [null, Validators.required],
                'endDate' : [null, Validators.required],
                'category' : [null, Validators.required],
                'creator' : {
                                "id": localStorage.getItem('id')
                            },
            });
    }

    checkDate(){
        if (Date.parse(this.formEvent.value["startDate"])<=Date.parse(this.formEvent.value["endDate"])){

            this.saveEventRequest();
        }
        else{

            this.notifier.notify( 'error', 'Event must Start before it Ends! Check and retry.' );
        }
    }

    /* Create Event Form */

    saveEventRequest(){

        console.log("insert event");

        for(let row of this.categoriesList) {
            if (row["id"] == this.formEvent.value["category"]) {
                this.formEvent.value["category"] = row;
            }
        }

        console.log(this.formEvent.value);

        this.restService.post("events", this.formEvent.value)
            .subscribe(res => {
                    console.log(res);
                    this.notifier.notify( 'success', 'Event correctly created!' );
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
