package br.com.alura.jpa_alura.teste;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.jpa_alura.modelo.Conta;
import br.com.alura.jpa_alura.modelo.Movimentacao;
import br.com.alura.jpa_alura.util.JPAUtil;

public class LazyLoadingTeste {

	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager("jpa_alura");
		
		manager.getTransaction().begin();
		
		Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes");
		
		List<Conta> contas = query.getResultList();
		
		Consumer<Conta> action = new Consumer<Conta>() {

			@Override
			public void accept(Conta c) {
				
				for (Movimentacao mov : c.getMovimentacoes()) {
					System.out.println(mov);
				}
				
			}
			
		};
		
		contas.forEach(action );
		
		manager.getTransaction().commit();
		manager.close();
		JPAUtil.getFactory().close();
	}

}
