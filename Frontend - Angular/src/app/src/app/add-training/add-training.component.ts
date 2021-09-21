import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Course } from '../model/course';
import { Faculty } from '../model/faculty';
import { Training } from '../model/training';
import { TrainingService } from '../service/training.service';


@Component({
  selector: 'app-add-training',
  templateUrl: './add-training.component.html',
  styleUrls: ['./add-training.component.css']
})
export class AddTrainingComponent implements OnInit {
  addForm: FormGroup;
  model: Training;
  submitted = false;
  errorMessage: any;
  isSuccessful: boolean;
  isAddFailed: boolean;
  faculties: Faculty[];
  courses: Course[];

  constructor(private formBuilder: FormBuilder, private service: TrainingService, private router: Router) {
    this.model = new Training();
  }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      trainingName: ['', Validators.required],
      faculty: ['', Validators.required],
      course: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],

    });

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
  }

  get f() { return this.addForm.controls; }

  onReset() {
    this.submitted = false;
    this.addForm.reset();
    this.router.navigateByUrl('/viewtrainings');
  }

  onSubmit() {
    this.submitted = true;
    this.model.trainingName = this.f.trainingName.value,
    this.model.faculty = this.f.faculty.value,
    this.model.course = this.f.course.value,
    this.model.startDate = this.f.startDate.value,
    this.model.endDate = this.f.endDate.value

    this.service.addTraining(this.model).subscribe(
      data => {
        this.model = data;
        this.isSuccessful = true;
        this.router.navigateByUrl('/viewtrainings');
      }
    );
  }

}
