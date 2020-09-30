package com.protocolService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protocolService.dao.PatientDao;
import com.protocolService.model.Patient;

@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	PatientDao patientDao;

	/**
	 * Gets all Patients that have been stored with 'getPatient' request.
	 * @return The list of {@link Patient} that are currently stored. Will not be {@code null}, but
	 * can be {@code isEmpty}.
	 */
	@GetMapping("/getPatient")
	public List<Patient> get(){
		return patientDao.findAll();
	}

	/**
	 * Handles '/addPatient' {@code POST} request and inserts a protocol into storage.
	 * @param Patient {@link Patient} to be inserted. Cannot be {@code null}.
	 * @return the Patient that is inserted
	 */
	@PostMapping("/addPatient")
	public Patient save(@RequestBody Patient patient) {
		return patientDao.save(patient);
	}

	/**
	 * Handles '/getPatient/{patientId}' {@code GET} request and return Patient associated with the ID.
	 * @return Patient {@link Patient} stored. Cannot be {@code null}.
	 */
	@GetMapping("/getPatient/{patientId}")
	public Patient get(@PathVariable int patientId) {
		Optional<Patient> patient = patientDao.findById(patientId);
		if(patient.isPresent()) 
			return patient.get();
		else
			throw new RuntimeException("Patient not found for the Id:"+patientId);
	}

	/**
	 * Handles '/updatePatient' {@code PUT} request and updates a Patient into storage.
	 * @param Patient {@link Patient} to be updates. Cannot be {@code null}.
	 * @return the Patient that is updated.
	 */
	@PutMapping("/updatePatient")
	public Patient update(@RequestBody Patient patient) {
		return patientDao.save(patient);
	}

	/**
	 * Handles '/deletePatient/{patientId}' {@code DELETE} request and deletes a Patient from storage.
	 * @param Patient {@link Patient} to be deleted. Cannot be {@code null}.
	 * @return the PatientID that is deleted.
	 */
	@DeleteMapping("/deletePatient/{patientId}")
	public String delete(@PathVariable int patientId) {
		Optional<Patient> patient = patientDao.findById(patientId);
		if(patient.isPresent()) {
			patientDao.delete(patient.get());
			return "Patient has been deleted with id:"+patientId;
		}
		else
			throw new RuntimeException("Patient not found with id:"+patientId);
	}


}