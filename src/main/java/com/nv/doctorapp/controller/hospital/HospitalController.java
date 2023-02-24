package com.nv.doctorapp.controller.hospital;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nv.doctorapp.dto.hospital.HospitalDTO;
import com.nv.doctorapp.entity.Hospital;

import com.nv.doctorapp.service.hospital.IHospitalService;
import com.nv.doctorapp.util.hospital.HospitalDTOConvertor;

@RestController
@RequestMapping("/hospital")

public class HospitalController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IHospitalService iHospitalService;

	@Autowired
	HospitalDTOConvertor dtoConvertor;
	
	
	public HospitalController() {
		logger.info("Hospital Controller called");
		System.err.println("Hospital Rest Controller called");

	}

	@PostMapping("/add")
	public ResponseEntity<HospitalDTO> saveHospital(@RequestBody Hospital hospital) throws Exception{
		Hospital savedHospital = iHospitalService.addHospital(hospital);
		logger.info("Hospital Saved" + savedHospital);

		HospitalDTO dto = dtoConvertor.convertTo(savedHospital);

		return new ResponseEntity<HospitalDTO>(dto, HttpStatus.OK);

	}

	@GetMapping("/list")
	public ResponseEntity<List<HospitalDTO>> getallHospital() {

		List<Hospital> allHospital = iHospitalService.getallHospital();

		List<HospitalDTO> dtoList = new ArrayList<>();
		for (Hospital hospital : allHospital) {
			HospitalDTO dtoObj = dtoConvertor.convertTo(hospital);
			dtoList.add(dtoObj);
		}

		return new ResponseEntity<List<HospitalDTO>>(dtoList, HttpStatus.OK);

	}

	@DeleteMapping("/deleteHospital/{hospitalId}")

	public void deleteHospital(@PathVariable int hospitalId) {
		iHospitalService.deleteHospitalById(hospitalId);
	}

	
	  @GetMapping("/id/{hospitalId}") 
	  
	  
	  public ResponseEntity<HospitalDTO> getHospitalById(@PathVariable int hospitalId){
		  
		  
		Hospital savedHospital =iHospitalService.getHospitalById(hospitalId);
		HospitalDTO dto = dtoConvertor.convertTo(savedHospital);
		return new ResponseEntity<HospitalDTO>(dto, HttpStatus.OK); 
		  
	  }	
	  
	  @PutMapping("/getHospital/{hospitalId}")
		public String updateHospital(@PathVariable int hospitalId) throws Exception
		{
			Hospital updatedHospital = iHospitalService.updateHospitalById(hospitalId);
			return updatedHospital.toString();
		}
	  
	  @GetMapping("/city/{city}")
	  public ResponseEntity<List<HospitalDTO>>getHospitalByCity(@PathVariable String city){
		  List<Hospital> allHospitals = iHospitalService.getHospitalByCity(city);
		  List<HospitalDTO> dto=new ArrayList<>();
		  for(Hospital hospital: allHospitals)
		  {
			  dto.add(dtoConvertor.convertTo(hospital));
		  }
		  
		  return new ResponseEntity<List<HospitalDTO>>(dto, HttpStatus.OK);
		  
	  }
	  
	  @GetMapping("/state/{state}")
	  public ResponseEntity<List<HospitalDTO>>getHospitalByState(@PathVariable String state){
		  List<Hospital> allHospitals = iHospitalService.getHospitalByState(state);
		  List<HospitalDTO> dtoObj=new ArrayList<>();
		  for(Hospital hospital: allHospitals)
		  {
			  dtoObj.add(dtoConvertor.convertTo(hospital));
		  }
		  
		  return new ResponseEntity<List<HospitalDTO>>(dtoObj, HttpStatus.OK);
		  
	  }
	  
	
		
	  
	  
}
