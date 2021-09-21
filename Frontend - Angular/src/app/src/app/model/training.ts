import { Course } from './course';
import { Faculty } from './faculty';

export class Training {

    public id : number;
    public trainingName: string;
    public startDate : Date;
    public endDate : Date;
    public faculty : Faculty;
    public course : Course;
}


