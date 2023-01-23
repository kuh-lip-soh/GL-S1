import { Routes } from "@angular/router";
import { ActivityListComponent } from "./app/activity-list/activity-list.component";
import { MapComponent } from "./app/map/map.component";

export const appRoutes: Routes = [
    {   path:"activities", component: ActivityListComponent },
    {   path:"activity/:id", component: MapComponent },
    {   path:"", redirectTo:"/activities", pathMatch:'full'}
]