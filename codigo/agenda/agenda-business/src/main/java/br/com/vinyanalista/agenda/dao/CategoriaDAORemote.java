package br.com.vinyanalista.agenda.dao;

import java.util.List;

import javax.ejb.Remote;

import br.com.vinyanalista.agenda.modelo.Categoria;

@Remote
public interface CategoriaDAORemote {

	public Categoria inserir(Categoria categoria);

	public Categoria buscar(Integer id);

	public void atualizar(Categoria categoria);

	public List<Categoria> listarTodas();

	public void remover(Categoria categoria);

}