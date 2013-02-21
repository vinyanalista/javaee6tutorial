package br.com.vinyanalista.agenda.web.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.vinyanalista.agenda.modelo.Contato;

@ManagedBean
public class ListaContatosBean {

	public List<Contato> getContatos() {
		List<Contato> contatos = new ArrayList<Contato>();

		Contato contato1 = new Contato();
		contato1.setNome("Antonio Vinicius");
		contato1.setTelefone("1212341234");
		contato1.setEmail("vinyanalista@gmail.com");
		contatos.add(contato1);

		Contato contato2 = new Contato();
		contato2.setNome("Joao");
		contato2.setTelefone("5656785678");
		contatos.add(contato2);

		Contato contato3 = new Contato();
		contato3.setNome("Jose");
		contato3.setTelefone("1234567890");
		contato3.setEmail("jose@exemplo.com");
		contatos.add(contato3);

		return contatos;
	}

}