package br.com.vinyanalista.agenda.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.vinyanalista.agenda.modelo.Contato;

@Local
public interface ContatoDAOLocal {

	public Contato inserir(Contato contato);

	public Contato buscar(Integer id);

	public void atualizar(Contato contato);

	public List<Contato> listarTodos();

	public void remover(Contato contato);

}