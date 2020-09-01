import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StudentRegistrationService {

  constructor(private http:HttpClient) { }

  public doStudentRegistration(student){
      return this.http.post("http://localhost:8080/virtusa/student/signup",student,{responseType: 'text' as 'json'})
  }
}
