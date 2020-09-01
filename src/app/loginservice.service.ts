import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  constructor(private http:HttpClient) { }

  public studentLogin(username: string , password : string){
    const headers = new HttpHeaders({AUthorization: 'Basic' +btoa(username+":"+password)});
     return this.http.get("http://localhost:8080/",{headers,responseType: 'text' as 'json'})
  }
}
