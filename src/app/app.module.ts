import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule,routes } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegistrationcomponentComponent } from './registrationcomponent/registrationcomponent.component';
import { LogincomponentComponent } from './logincomponent/logincomponent.component';
import { MatButtonModule} from "@angular/material/button";
import { MatToolbarModule  } from "@angular/material/toolbar";
import {MatIconModule} from '@angular/material/icon';
import { RouterModule, Routes } from '@angular/router';
import {MatDatepickerModule} from  '@angular/material/datepicker';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatNativeDateModule } from "@angular/material/core";
import { MatCheckboxModule } from "@angular/material/checkbox";
import { MatCardModule } from "@angular/material/card";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { MatListModule } from "@angular/material/list";
import { MatRadioModule } from "@angular/material/radio";
import { FlexLayoutModule } from "@angular/flex-layout";
import { StudentRegistrationService } from "./student-registration.service";
import { LoginserviceService } from "./loginservice.service";
import { HttpClientModule } from '@angular/common/http';
import {MatVideoModule } from "mat-video";

import {MatMenuModule} from '@angular/material/menu';
import {MatChipsModule} from '@angular/material/chips';




import { SelectioncomponentComponent } from './selectioncomponent/selectioncomponent.component';
import { HighersectionComponent } from './highersection/highersection.component';
import { PrekgsectionComponent } from './prekgsection/prekgsection.component';
import { MainComponent } from './main/main.component';
@NgModule({
  declarations: [
    AppComponent,
    RegistrationcomponentComponent,
    LogincomponentComponent,
    SelectioncomponentComponent,
    HighersectionComponent,
    PrekgsectionComponent,
    MainComponent
  ],
  imports: [
    MatChipsModule,
    MatVideoModule,
    HttpClientModule,
    FlexLayoutModule,
    MatInputModule,
    MatListModule,
    MatRadioModule,
    MatFormFieldModule,
    MatCardModule,
    FormsModule, 
    ReactiveFormsModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatIconModule,
    MatCheckboxModule,
    BrowserModule,
    AppRoutingModule,
    MatButtonModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    MatNativeDateModule,
    MatMenuModule,
  
 
    RouterModule.forRoot(routes),
 
  ],
  providers: [StudentRegistrationService,LoginserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }




