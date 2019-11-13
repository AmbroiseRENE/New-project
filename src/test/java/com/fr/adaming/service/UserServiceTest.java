package com.fr.adaming.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.query.ReturnedType;

import com.fr.adaming.entity.Employee;

//ON appelle le context de la vrai application
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private EmployeeService service;
	
	@Test
	public void createValidUser_shouldReturnUserWithIdNotNull() {
		
		//preparer les input 
		Employee e = new Employee();
		e.setNom("nom");
		e.setEmail("email@gmail.fr");
		e.setPwd("azerty");
		
		// invocation de la methode
		Employee retournedEmployee = service.save(e);
		
		
		// verification du resultat
		assertNotNull(retournedEmployee);
		assertNotNull(retournedEmployee.getId());
		assertNotNull(retournedEmployee.getNom());
		assertNotNull(retournedEmployee.getPwd());
		
		assertTrue(e.getNom()==retournedEmployee.getNom());
		assertTrue(e.getEmail()==retournedEmployee.getEmail());
		assertTrue(e.getPwd()==retournedEmployee.getPwd());
		 
	}
	
	
	
}
