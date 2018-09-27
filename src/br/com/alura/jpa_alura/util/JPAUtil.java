package br.com.alura.jpa_alura.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManager manager;
	
	public static EntityManager getEntityManager(String persistenceUnit) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnit);
	
		manager = factory.createEntityManager();
		
		return manager;
	}
}
