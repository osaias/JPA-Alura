package br.com.alura.jpa_alura.teste;

import javax.persistence.EntityManager;

import br.com.alura.jpa_alura.modelo.Conta;
import br.com.alura.jpa_alura.util.JPAUtil;

public class ContaTeste {

	public static void main(String[] args) {

		Conta c = new Conta();
		c.setBanco("Banco do Brasil");
		c.setAgencia("1547-7");
		c.setNumero("12.345-8");
		c.setTitular("Osaias");
		
		EntityManager manager = JPAUtil.getEntityManager("jpa_alura");
		
		manager.getTransaction().begin();
		
		manager.persist(c);
		
		manager.getTransaction().commit();
		manager.close();
	}

}
