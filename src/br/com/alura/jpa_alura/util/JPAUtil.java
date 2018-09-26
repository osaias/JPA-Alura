package br.com.alura.jpa_alura.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static EntityManager getEntityManager(String persistenceUnit) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnit);
	
		return factory.createEntityManager();
	}
}
