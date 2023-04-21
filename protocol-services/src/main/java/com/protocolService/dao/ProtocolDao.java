package com.protocolService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.protocolService.model.Protocol;

@Repository
public interface ProtocolDao extends JpaRepository<Protocol, Integer> {
	
}
