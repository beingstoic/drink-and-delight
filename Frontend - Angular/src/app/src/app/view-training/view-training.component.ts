import { Component, OnInit} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../model/course';
import { Faculty } from '../model/faculty';
import { Training } from '../model/training';
import { TrainingService } from '../service/training.service';

@Component({
  selector: 'app-view-training',
  templateUrl: './view-training.component.html',
  styleUrls: ['./view-training.component.css']
})
export class ViewTrainingComponent implements OnInit {
  displayedColumns = ['id', 'trainingName', 'facultyName', 'courseName', 'startDate', 'endDate','actions'];
  model: Training;
  faculties: Faculty[];
  courses: Course[];
  dataSource : Training[];
  errorMessage: any;
  

  constructor(private router: Router, private service : TrainingService) {
    this.model = new Training;
  }

  ngOnInit(): void {
    this.service
      .getFaculties()
      .subscribe((faculties: any) => {
        this.faculties = faculties;
      });

      this.service
      .getCourses()
      .subscribe((courses: any) => {
        this.courses = courses;
      });
    this.service
      .getTrainings()
      .subscribe((trainings: any) => {
        this.dataSource = trainings;
      });
      
  }

  refresh() {
    window.location.reload();
  }

  addNew(): void {
    this.router.navigateByUrl('/addtraining');
  }

  editItem(item : number): void {
    this.router.navigate(['edittraining', item]);
  }

  deleteItem(item : number): void {
    this.service.deleteTraining(item).subscribe(
      data => {
        console.log(data);
       this.refresh();
      },
      err => {
        this.errorMessage = err.message;
        alert(this.errorMessage);
      }
    );
  }
    

}



