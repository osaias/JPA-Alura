package br.com.alura.jpa_alura.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.jpa_alura.modelo.Conta;
import br.com.alura.jpa_alura.modelo.Movimentacao;
import br.com.alura.jpa_alura.modelo.TipoMovimentacao;
import br.com.alura.jpa_alura.util.JPAUtil;

public class MovimentacaoContaTeste {

	public static void main(String[] args) {

		//persistindo uma movimentação com uma nova conta
		/*Conta conta = new Conta();
		conta.setAgencia("0147-8");
		conta.setBanco("Banco Itaú");
		conta.setNumero("12.3456-8");
		conta.setTitular("Pedro Da Silva");
		
		Movimentacao mov = new Movimentacao();
		mov.setConta(conta);
		mov.setData(Calendar.getInstance());
		mov.setDescricao("Pagamento em dinheiro");
		mov.setTipo(TipoMovimentacao.SAIDA);
		mov.setValor(new BigDecimal("200.0"));
		
		EntityManager manager = JPAUtil.getEntityManager("jpa_alura");
		manager.getTransaction().begin();
		
		manager.persist(conta);
		manager.persist(mov);
		
		manager.getTransaction().commit();
		manager.close();*/
		
		//persistindo uma movimentação com uma conta existente
		Movimentacao mov = new Movimentacao();
		mov.setData(Calendar.getInstance());
		mov.setDescricao("Pagamento em Credito");
		mov.setTipo(TipoMovimentacao.ENTRADA);
		mov.setValor(new BigDecimal("1000.0"));
		
		EntityManager manager = JPAUtil.getEntityManager("jpa_alura");
		manager.getTransaction().begin();
		
		Conta conta = manager.find(Conta.class, 4);
		mov.setConta(conta);
		
		manager.persist(mov);
		manager.getTransaction().commit();
		manager.close();
		JPAUtil.getFactory().close();

	}

}
