package com.nv.doctorapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hospitalId;
	
	private String hospitalName;
	private String city;
	private String state;
	private String address;
	private int hospitalRating;
	// private list<doctor>
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "HospitalId") 
	private List<Doctor> doctors;
	
	public Hospital(int hospitalId, String HospitalName ,String city, String state, String address, int hospitalRating) 
	{
		super();
		this.hospitalId = hospitalId;
		this.hospitalName=hospitalName;
		this.city = city;
		this.state = state;
		this.address = address;
		this.hospitalRating = hospitalRating;
	}
	
	
	
}