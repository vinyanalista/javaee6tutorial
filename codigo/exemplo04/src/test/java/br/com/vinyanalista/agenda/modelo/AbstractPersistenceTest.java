package br.com.vinyanalista.agenda.modelo;

import static org.junit.Assert.*;

import javax.persistence.*;

import org.junit.*;

public class AbstractPersistenceTest {

	protected static EntityManagerFactory entityManagerFactory;
	protected static EntityManager entityManager;
	protected static EntityTransaction transaction;

	@Before
	public void inicializarEntityManager() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("agenda");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();

		assertNotNull(entityManager); // Teste
		assertNotNull(transaction); // Teste
	}

	@After
	public void initTransaction() {
		if (entityManager != null)
			entityManager.close();
		if (entityManagerFactory != null)
			entityManagerFactory.close();
	}

}