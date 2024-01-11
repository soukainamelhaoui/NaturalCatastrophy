import { donateAll } from "./donate-money";
import { volunteer } from "./volunteer";

export interface contribution {
    id: number;
    name?: string;
    departureDate?: string;
    departureCity?: string;
    vehicle?: Date;
    city?: Date;
    volunteers?: volunteer[];
    itemIds?: donateAll[];
    itemNames:Array<string>;
    isDone:boolean;
    volunteerUsernames:Array<string>;
}
