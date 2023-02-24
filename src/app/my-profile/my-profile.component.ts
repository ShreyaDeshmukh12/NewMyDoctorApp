import { Component } from '@angular/core';
import { PatientDTO } from '../patient-dto';
import { PatientOperationsService } from '../patient-operations.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent {

  patient:PatientDTO=new PatientDTO(0,'','',0,'','','','');

 
  
constructor(private patientService:PatientOperationsService)
  {

  }

  getPatients(pId:string){
    let patientId:number = parseInt(pId);
    this.patientService.getPatientDetailsById(patientId).subscribe(
      data=>{
        console.log("data :- "+data);
        
        this.patient = data;
      },err=>{
        console.log("error from spring ",err);
  
      } 
    );
  }
}
