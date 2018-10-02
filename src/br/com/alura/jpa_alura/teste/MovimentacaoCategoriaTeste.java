package br.com.alura.jpa_alura.teste;

import java.util.Arrays;

import javax.persistence.EntityManager;

import br.com.alura.jpa_alura.modelo.Categoria;
import br.com.alura.jpa_alura.modelo.Movimentacao;
import br.com.alura.jpa_alura.util.JPAUtil;

public class MovimentacaoCategoriaTeste {

	public static void main(String[] args) {

		Categoria alimentacao = new Categoria("Alimentação");
		Categoria viagem = new Categoria("Viagem");

		EntityManager manager = JPAUtil.getEntityManager("jpa_alura");

		manager.getTransaction().begin();

		//setando as categorias como managed
		manager.persist(viagem);
		manager.persist(alimentacao);

		//datached para managed
		Movimentacao mov1 = manager.find(Movimentacao.class, 1);
		Movimentacao mov2 = manager.find(Movimentacao.class, 2);

		mov1.setCategorias(Arrays.asList(alimentacao, viagem));
		mov2.setCategorias(Arrays.asList(viagem));

		manager.persist(mov1);
		manager.persist(mov2);

		manager.getTransaction().commit();
		manager.close();

	}

}
