package br.com.alura.jpa_alura.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.jpa_alura.modelo.Conta;
import br.com.alura.jpa_alura.modelo.Movimentacao;
import br.com.alura.jpa_alura.util.JPAUtil;

public class ContaMovimentacaoTeste {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.getEntityManager("jpa_alura");

		manager.getTransaction().begin();

		Movimentacao mov = manager.find(Movimentacao.class, 3);

		Conta conta = mov.getConta();
		System.out.println("Movimentações para conta ID: " + conta.getId());

		List<Movimentacao> movs = conta.getMovimentacoes();
		movs.forEach(System.out::println);

		manager.getTransaction().commit();
		manager.close();
		JPAUtil.getFactory().close();

	}

}
