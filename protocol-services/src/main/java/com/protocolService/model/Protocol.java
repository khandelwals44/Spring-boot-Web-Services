package com.protocolService.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "protocols")
public class Protocol {
	
	public Protocol(String protocolName, String protocolDetails) {
		this.protocol_name=protocolName;
		this.protocol_details=protocolDetails;
	}
	
	public Protocol() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer protocol_id;
	
	@Column
	private String protocol_name;
	
	@Column
	private String protocol_details;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "protocol_id")
	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	@Fetch(FetchMode.SELECT)
	private Set<Patient> patientList;

	public Integer getProtocol_id() {
		return protocol_id;
	}

	public void setProtocol_id(Integer protocol_id) {
		this.protocol_id = protocol_id;
	}

	public String getProtocol_name() {
		return protocol_name;
	}

	public void setProtocol_name(String protocol_name) {
		this.protocol_name = protocol_name;
	}

	public String getProtocol_details() {
		return protocol_details;
	}

	public void setProtocol_details(String protocol_details) {
		this.protocol_details = protocol_details;
	}
}
