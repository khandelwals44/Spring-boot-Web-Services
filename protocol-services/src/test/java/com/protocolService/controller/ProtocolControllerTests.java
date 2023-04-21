package com.protocolService.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.protocolService.dao.ProtocolDao;
import com.protocolService.model.Protocol;

import javassist.NotFoundException;



@SpringBootTest
public class ProtocolControllerTests {

	@InjectMocks
	ProtocolController protocolController;

	@Mock
	ProtocolDao protocolDao;

	/**
	 * Tests getProtocols method when multiple protocols has been stored. Validates the expected Protocol list
	 * is the same as the one fetched through the controller, and verifies the findAll method was
	 * called exactly once.
	 */
	@Test
	public void testGetAllProtocol() 
	{
		// given
		Protocol Protocol = new Protocol("Lokesh", "howtodoinjava@gmail.com");
		Protocol Protocol1 = new Protocol("Alex", "example@gmail.com");
		List<Protocol> list = new ArrayList<Protocol>();
		list.addAll(Arrays.asList(Protocol, Protocol1));

		when(protocolDao.findAll()).thenReturn(list);

		// when
		List<Protocol> result = protocolController.getProtocol();

		// then

		assertThat(result.get(0).getProtocol_name())
		.isEqualTo(Protocol.getProtocol_name());

		assertThat(result.get(1).getProtocol_details())
		.isEqualTo(Protocol1.getProtocol_details());

		verify(protocolDao,times(1)).findAll();
	}

	/**
	 * Tests get(protocolId) method. Validates the expected Protocol
	 * is the same as the one fetched through the controller, and verifies the findById method was
	 * called exactly once.
	 */
	@Test
	public void testGetProtocolById() throws Exception {
		int protocol_id =1;

		// Given
		Protocol protocol = new Protocol();
		protocol.setProtocol_id(protocol_id);
		protocol.setProtocol_name("name");
		protocol.setProtocol_details("details");
		Optional<Protocol> demoProtocol =Optional.of(protocol);

		when(protocolDao.findById(protocol_id)).thenReturn(demoProtocol);

		// when
		Protocol result = protocolController.get(protocol_id);

		// then
		assertEquals(demoProtocol, Optional.of(result));
	}

	/**
	 * Tests save(protocolList) method. Validates the Protocol is stored in the database is the 
	 * same as one saved by the controller, 
	 * and return the saved protocol.
	 */
	@Test
	public void testSaveProtocol() {
		// given
		int protocol_id=1;
		Protocol protocol = new Protocol();
		protocol.setProtocol_id(protocol_id);
		Protocol protocolToAdd = new Protocol("Lokesh", "howtodoinjava@gmail.com");

		// when
		when (protocolDao.save(protocolToAdd)).thenReturn(protocolToAdd);

		Protocol result= protocolController.save(protocolToAdd);

		// then
		assertThat(result.getProtocol_name())
		.isEqualTo("Lokesh");	
	}

	/**
	 * Tests deleter(protocolId) method. Validates the Protocol deleted from the database is the 
	 * same as one deleted by the controller, 
	 * and return the deleted protocolId.
	 */
	@Test
	public void testDeleteProtocolByID() throws NotFoundException {
		int protocol_id=1;
		// Given
		Protocol protocol = new Protocol();
		protocol.setProtocol_id(protocol_id);
		protocol.setProtocol_name("name");
		protocol.setProtocol_details("details");
		Optional<Protocol> demoProtocol =Optional.of(protocol);

		when(protocolDao.findById(protocol_id)).thenReturn(demoProtocol);

		//when
		String result = protocolController.delete(protocol_id);

		//then
		assertEquals("Protocol has been deleted with id:"+protocol_id,result);
	}

	/**
	 * Tests update(protocolId) method. Validates the Protocol updated in the database is the 
	 * same as one updated by the controller, 
	 * and return the updated protocol.
	 */
	@Test
	public void testUpdateProtocolByID() {
		// given
		int protocol_id=1;
		Protocol protocol = new Protocol();
		protocol.setProtocol_id(protocol_id);
		Protocol protocolToAdd = new Protocol("Lokesh", "howtodoinjava@gmail.com");

		// when
		// then
		when (protocolDao.save(protocolToAdd)).thenReturn(protocolToAdd);

		Protocol result=protocolController.update(protocolToAdd);		
		assertThat(result.getProtocol_name())
		.isEqualTo("Lokesh");	
	}

}
