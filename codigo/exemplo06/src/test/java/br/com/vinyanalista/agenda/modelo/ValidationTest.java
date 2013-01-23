package br.com.vinyanalista.agenda.modelo;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.validation.*;

import org.junit.*;

public class ValidationTest extends AbstractPersistenceTest {

	protected static ValidatorFactory validatorFactory;
	protected static Validator validator;

	@Before
	public void inicializarValidator() throws Exception {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	@Test
	public void validarContatoSemTratarExcecao() throws Exception {
		// Tenta inserir contato
		Contato contato = new Contato();
		contato.setNome("João 18");
		contato.setTelefone("12345467");
		contato.setEmail("joao_email");

		transaction.begin();
		entityManager.persist(contato);
		transaction.commit();

		// Obtém os contatos inseridos
		String jpql = "select c from Contato c";
		TypedQuery<Contato> query = entityManager.createQuery(jpql,
				Contato.class);
		List<Contato> contatos = query.getResultList();

		assertEquals(1, contatos.size()); // Teste
	}

	@Test
	public void validarContatoTratandoExcecao() throws Exception {
		// Tenta inserir contato
		Contato contato = new Contato();
		contato.setNome("João 18");
		contato.setTelefone("12345467");
		contato.setEmail("joao_email");

		try {
			transaction.begin();
			entityManager.persist(contato);
			transaction.commit();
		} catch (ConstraintViolationException excecaoDeValidacao) {
			transaction.rollback();
			System.out.println("Erros:");
			Set<ConstraintViolation<?>> erros = excecaoDeValidacao
					.getConstraintViolations();
			for (ConstraintViolation<?> erro : erros) {
				System.out.println("-" + erro.getMessage());
			}
		}

		// Obtém os contatos inseridos
		String jpql = "select c from Contato c";
		TypedQuery<Contato> query = entityManager.createQuery(jpql,
				Contato.class);
		List<Contato> contatos = query.getResultList();

		assertEquals(1, contatos.size()); // Teste
	}

}