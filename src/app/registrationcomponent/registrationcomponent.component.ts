import { Component, OnInit } from '@angular/core';
import { Student } from "../student";
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import { StudentRegistrationService } from '../student-registration.service';
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-registrationcomponent ,form-field-prefix-suffix-example,input-error-state-matcher-example,chips-overview-example',
  templateUrl: './registrationcomponent.component.html',
  styleUrls: ['./registrationcomponent.component.css']
})
export class RegistrationcomponentComponent implements OnInit {
  hide = true;
  student: Student;
  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  matcher = new MyErrorStateMatcher();

  

  message:any;
  constructor(private service:StudentRegistrationService) {
    this.student = new Student();
   }

  ngOnInit(): void {

  }

  register(){
       let resp  = this.service.doStudentRegistration(this.student);
    resp.subscribe((data)=> this.message = data);
    }

    login(){
      window.open("http://localhost:8080","_self");
    }
 
}
