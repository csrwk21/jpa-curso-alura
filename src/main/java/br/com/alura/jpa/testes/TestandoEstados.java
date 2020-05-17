package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		
		//Transient	
		Conta conta = new Conta();
		
		conta.setTitular("Almiro");
		conta.setAgencia(767563);
		conta.setNumero(999999);
		//conta.setSaldo(saldo);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		//Transient ->  managed
		em.persist(conta);
		em.remove(conta);
		
		em.getTransaction().commit();
	}
}
