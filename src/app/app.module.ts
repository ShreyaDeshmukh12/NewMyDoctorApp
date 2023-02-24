import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { ViewPatientComponent } from './view-patient/view-patient.component';
import { MyProfileComponent } from './my-profile/my-profile.component';

const allLinks:Routes = [
  {path:'register',component:RegisterComponent},
  {path:'viewpatient',component:ViewPatientComponent},
  {path:'myprofile',component:MyProfileComponent},
  
  
]
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    ViewPatientComponent,
    MyProfileComponent,
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(allLinks),FormsModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
