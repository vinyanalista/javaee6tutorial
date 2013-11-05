package br.com.vinyanalista.agenda.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.vinyanalista.agenda.modelo.Categoria;

@Local
public interface CategoriaDAOLocal {

	public Categoria inserir(Categoria categoria);

	public Categoria buscar(Integer id);

	public void atualizar(Categoria categoria);

	public List<Categoria> listarTodas();

	public void remover(Categoria categoria);

}