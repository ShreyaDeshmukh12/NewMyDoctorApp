package com.nv.doctorapp.repository.patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nv.doctorapp.entity.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {

}
