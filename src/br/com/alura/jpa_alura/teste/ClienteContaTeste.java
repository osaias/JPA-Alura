package br.com.alura.jpa_alura.teste;

import javax.persistence.EntityManager;

import br.com.alura.jpa_alura.modelo.Cliente;
import br.com.alura.jpa_alura.modelo.Conta;
import br.com.alura.jpa_alura.util.JPAUtil;

public class ClienteContaTeste {

	public static void main(String[] args) {
		
		Cliente pedro = new Cliente();
		pedro.setEndereco("Rua das Flores, 25");
		pedro.setNome("Pedro da Silva");
		pedro.setProfissao("Professora");
		
		Cliente renata = new Cliente();
		renata.setEndereco("Rua das Flores, 25");
		renata.setNome("Renata");
		renata.setProfissao("Nadador");
		
		Conta conta = new Conta();
		conta.setId(6);
		
		pedro.setConta(conta);
		//renata.setConta(conta);
		
		EntityManager manager = JPAUtil.getEntityManager("jpa_alura");
		manager.getTransaction().begin();
		
		manager.persist(pedro);
		//manager.persist(renata);
		
		manager.getTransaction().commit();
		manager.close();
		JPAUtil.getFactory().close();
	}

}
