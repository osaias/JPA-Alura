package br.com.alura.jpa_alura.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.jpa_alura.modelo.Categoria;
import br.com.alura.jpa_alura.modelo.Conta;
import br.com.alura.jpa_alura.modelo.Movimentacao;
import br.com.alura.jpa_alura.util.JPAUtil;

public class JPQLTeste {

	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager("jpa_alura");
		
		manager.getTransaction().begin();
		
		//getDadosMovimentacao(manager);
		//getMovimentacaoPorCategoria(manager);
		getContaDaMovimentacao(manager);
		
		manager.getTransaction().commit();
		manager.close();
		JPAUtil.getFactory().close();
	}

	private static void getContaDaMovimentacao(EntityManager manager) {

		Conta conta = new Conta();
		conta.setId(6);
		
		Query query = manager.createQuery("select distinct(m.conta) from Movimentacao m join m.conta c where c = :pConta");
		query.setParameter("pConta", conta);
		
		List<Conta> contas = query.getResultList();
		
		contas.forEach(System.out::println);
		
		
	}

	private static void getMovimentacaoPorCategoria(EntityManager manager) {
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		Query query = manager.createQuery("select m from Movimentacao m join m.categorias c where c = :pCat");
		query.setParameter("pCat", categoria);
		
		List<Movimentacao> movs = query.getResultList();
		
		for (Movimentacao movimentacao : movs) {
			System.out.println(movimentacao);
		}
		
	}

	private static void getDadosMovimentacao(EntityManager manager) {

		Query query = manager.createQuery("select m from Movimentacao m");
		
		List<Movimentacao> mov = query.getResultList();
		
		mov.forEach(System.out::println);
		
	}

}
