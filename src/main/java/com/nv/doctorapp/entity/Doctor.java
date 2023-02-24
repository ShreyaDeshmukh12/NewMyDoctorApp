package com.nv.doctorapp.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctorId;
	private String doctorName;
	private String speciality;
	private String location;
	private String email;
	private double chargePerVisit;

	@Embedded
	private AvailabilityDates availabilityDates;

	public Doctor(String doctorName, String speciality, String location, String email, double chargePerVisit) {
		super();
		this.doctorName = doctorName;
		this.speciality = speciality;
		this.location = location;
		this.email = email;
		this.chargePerVisit = chargePerVisit;
	}

	public Doctor(String doctorName, String speciality, String location, String hospitalName, String email,
			double chargePerVisit, AvailabilityDates availabilityDates) {
		super();
		this.doctorName = doctorName;
		this.speciality = speciality;
		this.location = location;
		this.email = email;
		this.chargePerVisit = chargePerVisit;
		this.availabilityDates = availabilityDates;
	}

}