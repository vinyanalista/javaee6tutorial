package br.com.vinyanalista.agenda.modelo;

import static org.junit.Assert.*;

import org.junit.*;

public class EntityManagerTest extends AbstractPersistenceTest {

	@Test
	public void inserirObterContato() throws Exception {
		// Insere contato
		Contato contato = new Contato();
		contato.setNome("Ant�nio Vin�cius");
		contato.setTelefone("1212341234");
		contato.setEmail("vinyanalista@gmail.com");

		transaction.begin();
		entityManager.persist(contato);
		transaction.commit();

		// Obt�m contato
		contato = entityManager.find(Contato.class, 1);

		assertNotNull(contato); // Teste
	}

	@Test
	public void alterarContato() throws Exception {
		// Insere contato
		Contato contato = new Contato();
		contato.setNome("Ant�nio Vin�cius");
		contato.setTelefone("1212341234");
		contato.setEmail("vinyanalista@gmail.com");

		transaction.begin();
		entityManager.persist(contato);
		transaction.commit();

		// Obt�m contato
		contato = entityManager.find(Contato.class, 1);

		// Altera contato
		contato.setNome("Vin�cius Ant�nio");

		transaction.begin();
		entityManager.merge(contato);
		transaction.commit();

		// Obt�m contato
		contato = entityManager.find(Contato.class, 1);

		assertEquals(contato.getNome(), "Vin�cius Ant�nio"); // Teste
	}

	@Test
	public void removerContato() throws Exception {
		// Insere contato
		Contato contato = new Contato();
		contato.setNome("Ant�nio Vin�cius");
		contato.setTelefone("1212341234");
		contato.setEmail("vinyanalista@gmail.com");

		transaction.begin();
		entityManager.persist(contato);
		transaction.commit();

		// Obt�m contato
		contato = entityManager.find(Contato.class, 1);

		// Remove contato
		transaction.begin();
		entityManager.remove(contato);
		transaction.commit();

		// Tenta obter o contato rec�m removido
		contato = entityManager.find(Contato.class, 1);

		assertNull(contato); // Teste
	}

	@Test
	public void atribuirCategoria() throws Exception {
		// Insere contato
		Contato contato = new Contato();
		contato.setNome("Ant�nio Vin�cius");
		contato.setTelefone("1212341234");
		contato.setEmail("vinyanalista@gmail.com");

		transaction.begin();
		entityManager.persist(contato);
		transaction.commit();

		// Insere categoria
		Categoria categoria = new Categoria();
		categoria.setNome("Fam�lia");

		transaction.begin();
		entityManager.persist(categoria);
		transaction.commit();

		// Obt�m contato
		contato = entityManager.find(Contato.class, 1);

		// Obt�m categoria
		categoria = entityManager.find(Categoria.class, 1);

		// Atribui categoria a contato
		contato.getCategorias().add(categoria);

		transaction.begin();
		entityManager.merge(contato);
		entityManager.merge(categoria);
		transaction.commit();

		contato = entityManager.find(Contato.class, 1);

		assertTrue(!contato.getCategorias().isEmpty()); // Teste
	}

	@Test
	public void obterContatosDeUmaCategoria() throws Exception {
		// Insere contato 1
		Contato contato1 = new Contato();
		contato1.setNome("Ant�nio Vin�cius");
		contato1.setTelefone("1212341234");
		contato1.setEmail("vinyanalista@gmail.com");

		transaction.begin();
		entityManager.persist(contato1);
		transaction.commit();

		// Insere contato 2
		Contato contato2 = new Contato();
		contato2.setNome("Jo�o");
		contato2.setTelefone("5656785678");
		contato2.setEmail("joao@email.com");

		transaction.begin();
		entityManager.persist(contato2);
		transaction.commit();

		// Insere categoria
		Categoria categoria = new Categoria();
		categoria.setNome("Fam�lia");

		transaction.begin();
		entityManager.persist(categoria);
		transaction.commit();

		// Obt�m categoria
		categoria = entityManager.find(Categoria.class, 1);

		// Obt�m contato 1 e atribui-lhe a categoria
		contato1 = entityManager.find(Contato.class, 1);
		contato1.getCategorias().add(categoria);

		// Obt�m contato 2 e atribui-lhe a categoria
		contato2 = entityManager.find(Contato.class, 2);
		contato2.getCategorias().add(categoria);

		// Atribui categoria aos contatos
		transaction.begin();
		entityManager.merge(contato1);
		entityManager.merge(contato2);
		transaction.commit();

		categoria = entityManager.find(Categoria.class, 1);
		assertTrue(!categoria.getContatos().isEmpty()); // Teste
	}

	@Test
	public void removerContatoDeUmaCategoria() throws Exception {
		// Insere contato 1
		Contato contato1 = new Contato();
		contato1.setNome("Ant�nio Vin�cius");
		contato1.setTelefone("1212341234");
		contato1.setEmail("vinyanalista@gmail.com");

		transaction.begin();
		entityManager.persist(contato1);
		transaction.commit();

		// Insere contato 2
		Contato contato2 = new Contato();
		contato2.setNome("Jo�o");
		contato2.setTelefone("5656785678");
		contato2.setEmail("joao@email.com");

		transaction.begin();
		entityManager.persist(contato2);
		transaction.commit();

		// Insere categoria
		Categoria categoria = new Categoria();
		categoria.setNome("Fam�lia");

		transaction.begin();
		entityManager.persist(categoria);
		transaction.commit();

		// Obt�m categoria
		categoria = entityManager.find(Categoria.class, 1);

		// Obt�m contato 1 e atribui-lhe a categoria
		contato1 = entityManager.find(Contato.class, 1);
		contato1.getCategorias().add(categoria);

		// Obt�m contato 2 e atribui-lhe a categoria
		contato2 = entityManager.find(Contato.class, 2);
		contato2.getCategorias().add(categoria);

		// Atribui categoria aos contatos
		transaction.begin();
		entityManager.merge(contato1);
		entityManager.merge(contato2);
		transaction.commit();

		// Obt�m contato 1 e remove-lhe a categoria
		contato1 = entityManager.find(Contato.class, 1);
		contato1.getCategorias().remove(categoria);

		transaction.begin();
		entityManager.merge(contato1);
		transaction.commit();

		categoria = entityManager.find(Categoria.class, 1);
		assertTrue(!categoria.getContatos().contains(contato1)); // Teste
	}

}