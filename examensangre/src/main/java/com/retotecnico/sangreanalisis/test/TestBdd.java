package com.retotecnico.sangreanalisis.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

public class TestBdd {
	
	//testing de la base de datos
	//crearla con el testing
	//generen todas las tablas que tengo construidas en la aplicacion
	
	@Test
	public void createEntityManagerTest() {
		
		
		//crear objeto de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		
		//prueba 
		assertNotNull(em);
		
		em.close();
		
	}
	
	
	

}
