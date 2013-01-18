package br.com.vinyanalista.agenda.modelo;

import static org.junit.Assert.assertNotNull;

import javax.persistence.*;

import org.junit.Test;

public class JPATest {

	private static EntityManagerFactory emf;

	@Test
	public void atualizarBanco() throws Exception {
		emf = Persistence.createEntityManagerFactory("agenda");
		assertNotNull(emf);
	}

}