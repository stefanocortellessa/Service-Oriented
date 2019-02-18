import {Component, OnInit} from '@angular/core';
import {RestService} from "../rest.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit{

    itemList: Array<any>;

  constructor(private restService: RestService,
              private router: Router){}

    /* Get Event-Attraction List */

    getItemListRequest(){

        console.log("get event-attraction list");

        this.restService.get("events")
            .subscribe(data => {
                    console.log("First rest call: ");
                    console.log(data["eventsList"]["eventElement"]);
                    this.itemList = data["eventsList"]["eventElement"]
                    this.restService.get("attractions")
                        .subscribe(data => {
                                console.log("Second rest call: ");
                                console.log(data["attractionsList"]["attractionElement"]);
                                this.itemList = this.itemList.concat(data["attractionsList"]["attractionElement"])
                                console.log("List after concatenation: ");
                                console.log(this.itemList);
                                this.shuffle(this.itemList);
                                this.itemList = this.itemList.slice(0,15);
                                console.log("List after shuffling/drop: ");
                                console.log(this.itemList);
                            }, (err) => console.log(err)
                        )
                }, (err) => console.log(err)
            )
    }

    shuffle(array) {

        var currentIndex = array.length, temporaryValue, randomIndex;

        // While there remain elements to shuffle...
        while (0 !== currentIndex) {

            // Pick a remaining element...
            randomIndex = Math.floor(Math.random() * currentIndex);
            currentIndex -= 1;

            // And swap it with the current element.
            temporaryValue = array[currentIndex];
            array[currentIndex] = array[randomIndex];
            array[randomIndex] = temporaryValue;
        }

        return array;
    }

    route(id: string){

        this.router.navigateByUrl(`/event-detail/${id}`);
    }


    ngOnInit() {

        this.getItemListRequest();
    }
}
