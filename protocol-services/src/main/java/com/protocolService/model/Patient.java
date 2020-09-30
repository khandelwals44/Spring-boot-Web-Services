	package com.protocolService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer patient_id;
	
	@Column
	private String patient_firstname;
	
	@Column
	private String patient_lastname;
	
	@Column
	private Integer patient_age;
	
	@ManyToOne()
	@JoinColumn(name = "protocol_id")
	private Protocol protocol_id;


	public Integer getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_firstname() {
		return patient_firstname;
	}

	public void setPatient_firstname(String patient_firstname) {
		this.patient_firstname = patient_firstname;
	}

	public String getPatient_lastname() {
		return patient_lastname;
	}

	public void setPatient_lastname(String patient_lastname) {
		this.patient_lastname = patient_lastname;
	}

	public Integer getPatient_age() {
		return patient_age;
	}

	public void setPatient_age(Integer patient_age) {
		this.patient_age = patient_age;
	}

	public Protocol getProtocol_id() {
		return protocol_id;
	}

	public void setProtocol_id(Protocol protocol_id) {
		this.protocol_id = protocol_id;
	}	
	
}
