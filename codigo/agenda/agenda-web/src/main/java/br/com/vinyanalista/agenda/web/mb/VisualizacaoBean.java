package br.com.vinyanalista.agenda.web.mb;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.vinyanalista.agenda.dao.ContatoDAOLocal;
import br.com.vinyanalista.agenda.modelo.Contato;
import br.com.vinyanalista.agenda.web.util.JSFMessages;

@ManagedBean
@RequestScoped
public class VisualizacaoBean {

	private String idDoContato;

	private Contato contato;

	@EJB
	private ContatoDAOLocal daoContato;

	public void carregarContato() {
		if (idDoContato == null) {
			JSFMessages.exibirMensagem(FacesMessage.SEVERITY_ERROR,
					"Requisição inválida!");
			return;
		}
		try {
			contato = daoContato.buscar(Integer.parseInt(idDoContato));
		} catch (Exception excecao) {
			contato = null;
		}
		if (contato == null) {
			JSFMessages.exibirMensagem(FacesMessage.SEVERITY_ERROR,
					"Não existe contato com a ID fornecida como parâmetro!");
			return;
		}
	}

	public String getIdDoContato() {
		return idDoContato;
	}

	public Contato getContato() {
		return contato;
	}

	public void setIdDoContato(String idDoContato) {
		this.idDoContato = idDoContato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}