package br.com.vinyanalista.agenda.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.richfaces.component.UIExtendedDataTable;

import br.com.vinyanalista.agenda.modelo.Contato;

@ManagedBean
@ViewScoped
public class ListaContatosBean implements Serializable {
	private static final long serialVersionUID = 1L;

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

	private Collection<Object> selecao;
	
	public Collection<Object> getSelecao() {
		return selecao;
	}

	public void setSelecao(Collection<Object> selecao) {
		this.selecao = selecao;
	}

	private Contato contatoSelecionado = null;

	public Contato getContatoSelecionado() {
		return contatoSelecionado;
	}

	public void atualizarContatoSelecionado(AjaxBehaviorEvent evento) {
		UIExtendedDataTable dataTable = (UIExtendedDataTable) evento
				.getComponent();
		Object linhaAtual = dataTable.getRowKey();
		contatoSelecionado = null;
		for (Object linhaSelecionada : selecao) {
			dataTable.setRowKey(linhaSelecionada);
			if (dataTable.isRowAvailable()) {
				contatoSelecionado = (Contato) dataTable.getRowData();
			}
		}
		dataTable.setRowKey(linhaAtual);
	}

}