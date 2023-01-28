import { IActivity } from "./activity.model";

export const SAVED_ACTIVITIES: IActivity[] = [
    {
        "id": 1,
        "name": "Grand bassin",
        "date": new Date('11/10/2022'),
        "distance": 6.22,
        "comments": "It was cold but i like it",
        "gpxData": '../assets/gpx/1.gpx'
    },
    {
        "id": 2,
        "name": "Lala Setti",
        "date": new Date('12/06/2022'),
        "distance": 4.28,
        "comments": "The view is great up there",
        "gpxData": '../../assets/gpx/2.gpx'
    },
    {
        "id": 3,
        "name": "Long way home",
        "date": new Date('1/04/2023'),
        "distance": 8.41,
        "comments": "Lot a cars",
        "gpxData": '../../assets/gpx/3.gpx'
    },
    {
        "id": 4,
        "name": "Moh's plan",
        "date": new Date('1/10/2023'),
        "distance": 6.14,
        "comments": "Not a good plan",
        "gpxData": '../../assets/gpx/4.gpx'
    },
    {
        "id": 5,
        "name": "Night ride",
        "date": new Date('1/14/2023'),
        "distance": 12.7,
        "comments": "Chill night with the boys",
        "gpxData": '../../assets/gpx/5.gpx'
    }
]