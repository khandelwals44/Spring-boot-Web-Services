package com.protocolService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.protocolService.model.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, Integer> {
	
}
