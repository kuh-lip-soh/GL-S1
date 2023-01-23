import { Component, OnInit } from '@angular/core';
import { IActivity } from '../shared/activity.model';
import { ActivityService } from '../services/activity.service';

@Component({
  selector: 'app-activity-list',
  templateUrl: './activity-list.component.html',
  styleUrls: ['./activity-list.component.css']
})
export class ActivityListComponent {

  activities!: IActivity[];
  totalActivities!: number;
  totalDistance!: number;
  lastDate!: Date;

  constructor(private _activityService: ActivityService) {

  }

  ngOnInit() {
    this.activities = this._activityService.getActivities();
    this.totalActivities = this._activityService.getTotalActivities(this.activities);
    this.totalDistance = this._activityService.getTotalDistance(this.activities);
    this.lastDate = this._activityService.getLastDate(this.activities);
  }
}
