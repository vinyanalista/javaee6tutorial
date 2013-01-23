package br.com.vinyanalista.agenda.modelo;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.*;

public class JPQLTest extends AbstractPersistenceTest {

	@Test
	public void obterTodosOsContatos() throws Exception {
		// Insere 2 contatos
		Contato contato1 = new Contato();
		contato1.setNome("Antônio Vinícius");
		contato1.setTelefone("1212341234");

		Contato contato2 = new Contato();
		contato2.setNome("João");
		contato2.setTelefone("5656785678");

		transaction.begin();
		entityManager.persist(contato1);
		entityManager.persist(contato2);
		transaction.commit();

		// Obtém os contatos inseridos
		String jpql = "select c from Contato c";
		Query query = entityManager.createQuery(jpql);
		List contatos = query.getResultList(); //Advertência

		assertEquals(2, contatos.size()); // Teste
	}

	@Test
	public void typedQuery() throws Exception {
		// Insere 2 contatos
		Contato contato1 = new Contato();
		contato1.setNome("Antônio Vinícius");
		contato1.setTelefone("1212341234");

		Contato contato2 = new Contato();
		contato2.setNome("João");
		contato2.setTelefone("5656785678");

		transaction.begin();
		entityManager.persist(contato1);
		entityManager.persist(contato2);
		transaction.commit();

		// Obtém os contatos inseridos
		String jpql = "select c from Contato c";
		TypedQuery<Contato> query = entityManager.createQuery(jpql,
				Contato.class);
		List<Contato> contatos = query.getResultList();

		assertEquals(2, contatos.size()); // Teste
	}

	@Test
	public void namedQuery() throws Exception {
		// Insere 2 contatos
		Contato contato1 = new Contato();
		contato1.setNome("Antônio Vinícius");
		contato1.setTelefone("1212341234");

		Contato contato2 = new Contato();
		contato2.setNome("João");
		contato2.setTelefone("5656785678");

		transaction.begin();
		entityManager.persist(contato1);
		entityManager.persist(contato2);
		transaction.commit();

		// Obtém os contatos inseridos
		TypedQuery<Contato> query = entityManager.createNamedQuery(
				Contato.LISTAR_TODOS, Contato.class);
		List<Contato> contatos = query.getResultList();

		assertEquals(2, contatos.size()); // Teste
	}

}