package br.com.vinyanalista.agenda.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.vinyanalista.agenda.modelo.Categoria;

@Stateless
public class CategoriaDAO implements CategoriaDAORemote, CategoriaDAOLocal, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "agenda", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public Categoria inserir(Categoria categoria) {
		entityManager.persist(categoria);
		return categoria;
	}

	public Categoria buscar(Integer id) {
		return entityManager.find(Categoria.class, id);
	}

	public void atualizar(Categoria categoria) {
		entityManager.merge(categoria);
	}

	public List<Categoria> listarTodas() {
		return entityManager.createNamedQuery(Categoria.LISTAR_TODAS,
				Categoria.class).getResultList();
	}

	public void remover(Categoria categoria) {
		entityManager.remove(entityManager.find(Categoria.class,
				categoria.getId()));
	}

}