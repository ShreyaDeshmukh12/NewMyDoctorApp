import { Component } from '@angular/core';
import { Patient } from '../patient';
import { PatientDTO } from '../patient-dto';
import { PatientOperationsService } from '../patient-operations.service';

@Component({
  selector: 'app-view-patient',
  templateUrl: './view-patient.component.html',
  styleUrls: ['./view-patient.component.css']
})
export class ViewPatientComponent {

  allPatients:PatientDTO[]=[];

  constructor(private patientService:PatientOperationsService)
  {

  }

  getPatients(patientName:string){
    this.patientService.getPatientDetailsByName(patientName).subscribe(
      data=>{
        console.log("data :- "+data);
        
        this.allPatients = data;
      },err=>{
        console.log("error from spring ",err);
  
      } 
    );
  }

  getPatients2(patientCity:string){
    this.patientService.getPatientDetailsByCity(patientCity).subscribe(
      data=>{
        console.log("data :- "+data);
        
        this.allPatients = data;
      },err=>{
        console.log("error from spring ",err);

  
      } 
    );
  }

  getPatients3(patientDisease:string){
    this.patientService.getPatientDetailsByDisease(patientDisease).subscribe(
      data=>{
        console.log("data :- "+data);
        
        this.allPatients = data;
      },err=>{
        console.log("error from spring ",err);

  
      } 
    );
  }

}

