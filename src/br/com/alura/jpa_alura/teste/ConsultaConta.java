package br.com.alura.jpa_alura.teste;

import javax.persistence.EntityManager;

import br.com.alura.jpa_alura.modelo.Conta;
import br.com.alura.jpa_alura.util.JPAUtil;

public class ConsultaConta {

	public static void main(String[] args) {
		
		//manager 1
		EntityManager manager1 = JPAUtil.getEntityManager("jpa_alura");
		 manager1.getTransaction().begin();
		 
		Conta conta = manager1.find(Conta.class, 1);
		
		System.out.println(conta);
		
		manager1.getTransaction().commit();
		manager1.close();
		
		//manager 2
		EntityManager manager2 = JPAUtil.getEntityManager("jpa_alura");
		manager2.getTransaction().begin();
		
		conta.setTitular("Renata");
		manager2.merge(conta);
		
		manager2.getTransaction().commit();
		manager2.close();
		
	}

}
