package br.com.vinyanalista.agenda.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.vinyanalista.agenda.modelo.Contato;

@Stateless
public class ContatoDAO implements ContatoDAORemote, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "agenda")
	private EntityManager entityManager;

	public Contato inserir(Contato contato) {
		entityManager.persist(contato);
		return contato;
	}

	public Contato buscar(Integer id) {
		return entityManager.find(Contato.class, id);
	}

	public void atualizar(Contato contato) {
		entityManager.merge(contato);
	}

	public List<Contato> listarTodos() {
		return entityManager.createNamedQuery(Contato.LISTAR_TODOS,
				Contato.class).getResultList();
	}

	public void remover(Contato contato) {
		entityManager
				.remove(entityManager.find(Contato.class,
						contato.getId()));
	}

}