import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationcomponentComponent } from './registrationcomponent/registrationcomponent.component';
import { LogincomponentComponent  } from "./logincomponent/logincomponent.component";
import { SelectioncomponentComponent } from './selectioncomponent/selectioncomponent.component';
import { HighersectionComponent } from './highersection/highersection.component';
import { PrekgsectionComponent } from './prekgsection/prekgsection.component';
import { MainComponent } from './main/main.component';


export const routes: Routes = [
  { path: '', redirectTo: 'main', pathMatch: 'full' },
  { path: 'register', component: RegistrationcomponentComponent },
  { path: 'login', component: LogincomponentComponent },
  { path: 'select', component: SelectioncomponentComponent },
  { path: 'higher', component: HighersectionComponent },
  { path: 'prekg', component: PrekgsectionComponent },
  { path: 'main', component: MainComponent },
  { path: '**', component: MainComponent },

];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }




