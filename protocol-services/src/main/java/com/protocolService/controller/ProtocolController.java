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

import com.protocolService.dao.ProtocolDao;
import com.protocolService.model.Protocol;

@RestController
@RequestMapping("/protocol")
public class ProtocolController {

	@Autowired
	ProtocolDao protocolDao;

	/**
	 * Gets all protocols that have been stored with 'getProtocols' request.
	 * @return The list of {@link Protocol} that are currently stored. Will not be {@code null}, but
	 * can be {@code isEmpty}.
	 */
	@GetMapping("/getProtocol")
	public List<Protocol> getProtocol(){
		return protocolDao.findAll();
	}
	
	/**
	 * Handles '/AddProtocol' {@code POST} request and inserts a protocol into storage.
	 * @param protocol {@link Protocol} to be inserted. Cannot be {@code null}.
	 * @return the protocol that is inserted
	 */
	@PostMapping("/addProtocol")
	public Protocol save(@RequestBody Protocol protocolobj) {
		return protocolDao.save(protocolobj);	
	}
	
	/**
	 * Handles '/getProtocol/{protocol_id}' {@code GET} request and return protocol associated with the ID.
	 * @return protocol {@link Protocol} stored. Cannot be {@code null}.
	 */
	@GetMapping("/getProtocol/{protocol_id}")
	public Protocol get(@PathVariable int protocol_id) {
		Optional<Protocol> protocol = protocolDao.findById(protocol_id);
		if(protocol.isPresent()) 
			return protocol.get();
		else
			throw new RuntimeException("Patient not found for the Id:"+protocol_id);
	}

	/**
	 * Handles '/updateProtocol' {@code PUT} request and updates a protocol into storage.
	 * @param protocol {@link Protocol} to be updates. Cannot be {@code null}.
	 * @return the protocol that is updated.
	 */
	@PutMapping("/updateProtocol")
	public Protocol update(@RequestBody Protocol protocolobj) {
		return protocolDao.save(protocolobj);
	}
	
	/**
	 * Handles '/deleteProtocol/{protocol_id}' {@code DELETE} request and deletes a protocol from storage.
	 * @param protocol {@link Protocol} to be deleted. Cannot be {@code null}.
	 * @return the protocolID that is deleted.
	 */
	@DeleteMapping("/deleteProtocol/{protocol_id}")
	public String delete(@PathVariable int protocol_id) {
		Optional<Protocol> protocol =protocolDao.findById(protocol_id);
		if(protocol.isPresent()) {
			protocolDao.delete(protocol.get());
			return "Protocol has been deleted with id:"+protocol_id;
		}
		else
			throw new RuntimeException("Protocol not found with id:"+protocol_id);

	}


}
