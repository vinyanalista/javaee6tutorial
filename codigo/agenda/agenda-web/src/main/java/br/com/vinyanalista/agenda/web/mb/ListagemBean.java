package br.com.vinyanalista.agenda.web.mb;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.richfaces.component.UIExtendedDataTable;

import br.com.vinyanalista.agenda.dao.ContatoDAOLocal;
import br.com.vinyanalista.agenda.modelo.Contato;

@ManagedBean
@ViewScoped
public class ListagemBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ContatoDAOLocal daoContato;

	private Collection<Object> selecao;

	private Contato contatoSelecionado = null;

	public Collection<Object> getSelecao() {
		return selecao;
	}

	public void setSelecao(Collection<Object> selecao) {
		this.selecao = selecao;
	}

	public List<Contato> getListaDeContatos() {
		return daoContato.listarTodos();
	}

	public Contato getContatoSelecionado() {
		return this.contatoSelecionado;
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