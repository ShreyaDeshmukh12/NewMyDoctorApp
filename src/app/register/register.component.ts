import { Component } from '@angular/core';
import { Patient } from '../patient';
import { PatientOperationsService } from '../patient-operations.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
status=false;
message='';
  __patientService:PatientOperationsService;

  allPatients:Patient[]=[];

  p:Patient = new Patient(1,'','',0,'','','','')
  constructor(patientService:PatientOperationsService)
  {
    this.__patientService = patientService;
    this.allPatients=this.__patientService.getPatientArr();
  }

  doFormSubmit(){
    console.log(this.p);
    this.__patientService.Submit(this.p).subscribe(
      data=>{
        this.status=true;
        this.message="Patient Registered";
      },
      error=>{

      }
    )
  }



  readPatient(patientId:string,patientName:string,patientCity:string,patientAge:string,patientGender:string,patientDisease:string,patientPhoneNumber:string,patientBloodGroup:string)
  {
      console.log(patientId+" "+patientName+" "+patientCity+" "+patientAge+"  "+patientGender+" "+patientDisease+" "+patientPhoneNumber+" "+patientBloodGroup);
      let patientFromUser:Patient = new Patient(parseInt(patientId),patientName,patientCity,parseInt(patientAge),patientGender,patientDisease,patientPhoneNumber,patientBloodGroup);
      this.__patientService.submit(patientFromUser);
  }


}
