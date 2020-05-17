package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
		
		Categoria categoria = new Categoria();
		categoria.setId(2L);
		
		TypedQuery<Movimentacao> query = em.createQuery(jpql,Movimentacao.class);
		
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultList = query.getResultList();
		
		for (Movimentacao movimentacao : resultList) {
			System.out.println("Categorias: " + movimentacao.getCategoria());
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Descricao: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}

	}

}
