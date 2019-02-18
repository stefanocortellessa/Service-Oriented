import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SessionCheckerService} from "./session-checker.service";
import {EventDetailComponent} from "./event-detail/event-detail.component";
import {AttractionDetailComponent} from "./attraction-detail/attraction-detail.component";

const routes: Routes = [
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full' },
    {
        path: 'home',
        loadChildren: './home/home.module#HomePageModule' },
    {
        path: 'create-event',
        loadChildren: './create-event/create-event.module#CreateEventPageModule',
        canActivate: [SessionCheckerService]},
    {
        path: 'create-attraction',
        loadChildren: './create-attraction/create-attraction.module#CreateAttractionPageModule',
        canActivate: [SessionCheckerService]},
    {
        path: 'event-list',
        loadChildren: './event-list/event-list.module#EventListPageModule'},
    {
        path: 'attraction-list',
        loadChildren: './attraction-list/attraction-list.module#AttractionListPageModule'},
    {
        path: 'event-detail/:id',
        component: EventDetailComponent},
    {
        path: 'attraction-detail/:id',
        component: AttractionDetailComponent},
    {
        path: 'event-search',
        loadChildren: './event-search/event-search.module#EventSearchPageModule'},
    {
        path: 'login',
        loadChildren: './login/login.module#LoginPageModule'},
    {
        path: 'sign-up',
        loadChildren: './sign-up/sign-up.module#SignUpPageModule'},
    {
        path: 'attraction-search',
        loadChildren: './attraction-search/attraction-search.module#AttractionSearchPageModule',},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}