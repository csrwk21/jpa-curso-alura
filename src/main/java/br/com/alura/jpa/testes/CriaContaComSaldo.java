package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta");
		EntityManager em = emf.createEntityManager();
		
		Conta conta  = new Conta();
	
		conta.setTitular("Marcia");
		conta.setNumero(1234567);
		conta.setAgencia(654333);
		conta.setSaldo(500.0);
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		
		em.close();
		
		EntityManager em2 = emf.createEntityManager();
		System.out.println("id da conta da marcia" + conta.getId());
		conta.setSaldo(500.00);
		
		em2.getTransaction().begin(); 
		em2.merge(conta);
		em2.getTransaction().commit();
	}

}
