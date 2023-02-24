import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient';
import { PatientDTO } from './patient-dto';
@Injectable({
  providedIn: 'root'

  
})
export class PatientOperationsService {

  baseURL:string = 'http://localhost:2021';
  patientByIdEndPoint:string=this.baseURL+'/patient/id';
  patientByNameEndPoint:string=this.baseURL+'/patient/name';
  patientByCityEndPoint:string=this.baseURL+'/patient/city';
  patientByDiseaseEndPoint:string=this.baseURL+'/patient/disease';
  submitPatientEndpoint:string=this.baseURL+'/patient/register';

  patientArr:Patient[] = [];

  constructor(private http:HttpClient) { 

    console.log("Inside Constructor "+this.patientByIdEndPoint);
    console.log("Inside Constructor "+this.patientByNameEndPoint);
    console.log("Inside Constructor "+this.patientByCityEndPoint);
    console.log("Inside Constructor "+this.patientByDiseaseEndPoint);

    
  }

  getPatientDetailsByName(patientName:string):Observable<PatientDTO[]>{
    console.log("Inside Method 1 "+this.patientByNameEndPoint);
    this.patientByNameEndPoint=this.patientByNameEndPoint+'/'+patientName;
    console.log("After adding name 2 "+this.patientByNameEndPoint);

    return this.http.get<PatientDTO[]>(`${this.patientByNameEndPoint}`);
  }

  getPatientDetailsByCity(patientCity:string):Observable<PatientDTO[]>{
    console.log("Inside Method 1 "+this.patientByCityEndPoint);
    this.patientByCityEndPoint=this.patientByCityEndPoint+'/'+patientCity;
    console.log("After adding rcity 2 "+this.patientByCityEndPoint);

    return this.http.get<PatientDTO[]>(`${this.patientByCityEndPoint}`);
  }

  getPatientDetailsByDisease(patientDisease:string):Observable<PatientDTO[]>{
    console.log("Inside Method 1 "+this.patientByDiseaseEndPoint);
    this.patientByDiseaseEndPoint=this.patientByDiseaseEndPoint+'/'+patientDisease;
    console.log("After adding disease 2 "+this.patientByDiseaseEndPoint);

    return this.http.get<PatientDTO[]>(`${this.patientByDiseaseEndPoint}`);
  }

  getPatientDetailsById(patientId:number):Observable<PatientDTO>{
    console.log("Inside Method 1 "+this.patientByIdEndPoint);
    this.patientByIdEndPoint=this.patientByIdEndPoint+'/'+patientId;
    console.log("After adding id 2 "+this.patientByIdEndPoint);

    return this.http.get<PatientDTO>(`${this.patientByIdEndPoint}`);
  }

  Submit(patient:Patient):Observable<Patient>{
    console.log("Inside the method :"+patient);
  

    return this.http.post<Patient>(`${this.submitPatientEndpoint}`,patient);

  }


 


  submit(patientFromUser:Patient)
  {
    
    this.patientArr.push(patientFromUser); 
    console.log("Inside Patient Service : Patient Added "+patientFromUser.patientId);
    console.log(" Total Patient Are :- "+this.patientArr.length);
    
  }

  getPatientArr():Patient[]
  {
    return this.patientArr;
  }
  

}
