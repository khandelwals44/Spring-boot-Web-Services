//package com.protocolService.controller;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import com.protocolService.dao.PatientDao;
//import com.protocolService.model.Patient;
//
//
//public class PatientControllerTests {
//	
//	@InjectMocks
//    PatientController patientController;
//     
//    @Mock
//    PatientDao patientDAO;
//     
//    @Test
//    public void testAddPatient() 
//    {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//         
//       //when(patientDAO.save(any(Patient.class))).thenReturn(true);
//        Mockito.doReturn(true).when(patientDAO.save(any(Patient.class)));
//        Patient patient = new Patient("Lokesh", "Gupta",1);
//        ResponseEntity<Object> responseEntity = patientController.save(patient);
// 
//       assertThat(responseEntity.getStatusCode()).isEqualTo(201);
//       assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
//
//    }
//    
//    @Test
//	public void testFindAll() 
//	{
//		// given
//		Patient Patient = new Patient();
//		Patient.setPatient_age(22);
//		Patient.setPatient_firstname("shivam");
//		Patient.setPatient_lastname("khandelwal");
//		Patient.setProtocol_id("1");
//		Patient Patient1 = new Patient("Alex", "example@gmail.com",22,3);
//		List<Patient> list = new ArrayList<Patient>();
//		list.addAll(Arrays.asList(Patient, Patient1));
//
//		when(patientDAO.findAll()).thenReturn(list);
//
//		// when
//		List<com.protocolService.model.Patient> result = patientController.get();
//
//		// then
//		assertThat(result.size()).isEqualTo(2);
//		
//		assertThat(result.get(0).getPatient_firstname())
//						.isEqualTo(Patient.getPatient_firstname());
//		
//		assertThat(result.get(1).getPatient_firstname())
//						.isEqualTo(Patient1.getPatient_firstname());
//	}
//}