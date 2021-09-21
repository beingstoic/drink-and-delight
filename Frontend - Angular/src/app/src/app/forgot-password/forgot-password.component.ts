import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  passValidations: FormGroup;

  constructor(private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.passValidations = this.formBuilder.group({
      email:['', [ Validators.email, Validators.required ]],
    });
  }

  get email() { return this.passValidations.get('email'); }

  getEmailError() {
    if (this.email.hasError('email')) {
      return 'Please enter a valid email address.';
    }
    if (this.email.hasError('required')) {
      return 'An Email is required.';
    }
  };  

  clickReset(){}

}
