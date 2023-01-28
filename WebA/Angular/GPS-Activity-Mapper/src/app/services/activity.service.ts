import { Injectable } from '@angular/core';
import { IActivity } from '../shared/activity.model';
import { SAVED_ACTIVITIES } from '../shared/activities';

@Injectable()
export class ActivityService {

  constructor() { }

  getActivities(): IActivity[]{
    return SAVED_ACTIVITIES.slice(0);
  }

  getTotalActivities(allActivities: IActivity[])
  {
    return allActivities.length;
  }

  getTotalDistance(allActivities: IActivity[])
  {
    var totalDistance = 0;
    for(var i=0; i<allActivities.length; i++)
      {
        totalDistance += allActivities[i].distance;
      }
    return totalDistance;
  }

  getLastDate(allActivities: IActivity[])
  {
    var lastDate = new Date('01/01/1900');
    for(var i=0; i<allActivities.length; i++)
    {
      if(allActivities[i].date>lastDate)
      lastDate=allActivities[i].date;
    }
    return lastDate;
  }
}
