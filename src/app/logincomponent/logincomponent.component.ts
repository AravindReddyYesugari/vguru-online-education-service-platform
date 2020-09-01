import { Component, OnInit } from '@angular/core';
import { Login } from "../login";
import { LoginserviceService } from "../loginservice.service";


import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logincomponent',
  templateUrl: './logincomponent.component.html',
  styleUrls: ['./logincomponent.component.css']
})
export class LogincomponentComponent implements OnInit {
  login: Login;
  
  message:any;
  username : string;
  password :string;
   
  constructor(private service:LoginserviceService,private router:Router) {
   
   }

  ngOnInit(): void {
  }
 
    doLogin1(){
    let resp  = this.service.studentLogin(this.username,this.password);
    resp.subscribe((data)=> this.message = data);

    
   if(this.message === "success"){

    this.router.navigate(['/select']);
  }
}
}
