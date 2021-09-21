import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute,Router } from '@angular/router';
import { Faculty } from '../model/faculty';
import { Training } from '../model/training';
import { TrainingService } from '../service/training.service';

@Component({
  selector: 'app-edit-training',
  templateUrl: './edit-training.component.html',
  styleUrls: ['./edit-training.component.css']
})
export class EditTrainingComponent implements OnInit {
  editForm: FormGroup;
  submitted = false;
  model: Training;
  errorMessage: any;
  faculties: Faculty[];
  id: any;

  constructor(private formBuilder: FormBuilder, private service: TrainingService, private router: Router, private route: ActivatedRoute) {
    this.model = new Training;
   }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];

    this.service.getTraining(this.id).subscribe(
      data => {
        console.log(data);
        this.model = Object.assign(data);

      },
      err => {
        this.errorMessage = err.message;
        alert(this.errorMessage);
      }
    );
    

    this.service
      .getFaculties()
      .subscribe((faculties: any) => {
        this.faculties = faculties;
      });
     
  
    this.editForm = this.formBuilder.group({
      trainingName: ['', Validators.required],
      faculty: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required]
  });
  
  }
  
  get f() { return this.editForm.controls; }

  onSubmit() {
    this.submitted = true;
    this.model.trainingName = this.f.trainingName.value,
    this.model.faculty = this.f.faculty.value,
    this.model.startDate = this.f.startDate.value,
    this.model.endDate = this.f.endDate.value

    this.service.updateTraining(this.model).subscribe(
      data => {
        this.model = data;
        this.router.navigateByUrl('/viewtrainings');
      }
    );
}

onReset() {
    this.submitted = false;
    this.editForm.reset();
    this.router.navigateByUrl('/viewtrainings');
}

}
