import { Component, OnInit } from '@angular/core';

import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../rest-api.service';

@Component({
  selector: 'app-list',
  templateUrl: 'list.page.html',
  styleUrls: ['list.page.scss']
})

export class ListPage implements OnInit {

    classrooms: any;

    constructor(public api: RestApiService, public loadingController: LoadingController) { }

    async getClassrooms() {
      const loading = await this.loadingController.create({
        content: 'Loading'
      });
      await loading.present();
      await this.api.getClassroom()
        .subscribe(res => {
          console.log(res);
          this.classrooms = res;
          loading.dismiss();
        }, err => {
          console.log(err);
          loading.dismiss();
        });
    }








    private selectedItem: any;
    private icons = [
        'flask',
        'wifi',
        'beer',
        'football',
        'basketball',
        'paper-plane',
        'american-football',
        'boat',
        'bluetooth',
        'build'
    ];

    public items: Array<{ title: string; note: string; icon: string }> = [];
    constructor() {
    for (let i = 1; i < 11; i++) {
        this.items.push({
        title: 'Item ' + i,
        note: 'This is item #' + i,
        icon: this.icons[Math.floor(Math.random() * this.icons.length)]
        });
    }
    }

    ngOnInit() {
      this.getClassrooms();
    }
}
