package br.com.vinyanalista.agenda.web.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.vinyanalista.agenda.dao.CategoriaDAOLocal;
import br.com.vinyanalista.agenda.dao.ContatoDAOLocal;
import br.com.vinyanalista.agenda.modelo.Categoria;
import br.com.vinyanalista.agenda.modelo.Contato;
import br.com.vinyanalista.agenda.web.util.JSFMessages;

@ManagedBean
@ViewScoped
public class CadastroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean cadastro = false;

	private String idDoContato;

	private Contato contato;

	@EJB
	private ContatoDAOLocal daoContato;
	
	@EJB
	private CategoriaDAOLocal daoCategoria;

	public void preRenderView() {
		if (contato == null) {
			if (idDoContato != null) {
				try {
					contato = daoContato.buscar(Integer.parseInt(idDoContato));
				} catch (Exception excecao) {
					contato = null;
				}
				if (contato == null) {
					JSFMessages
							.exibirMensagem(FacesMessage.SEVERITY_ERROR,
									"Não existe contato com a ID fornecida como parâmetro!");
					return;
				}
			} else {
				contato = new Contato();
				cadastro = true;
			}
		}
	}

	public String salvar() {
		try {
			if (cadastro) {
				daoContato.inserir(contato);
				JSFMessages.exibirMensagemAposRedirecionar(
						FacesMessage.SEVERITY_INFO,
						"O contato foi adicionado com sucesso!");
			} else {
				daoContato.atualizar(contato);
				JSFMessages.exibirMensagemAposRedirecionar(
						FacesMessage.SEVERITY_INFO,
						"O contato foi alterado com sucesso!");
			}
			return "index.xhtml?faces-redirect=true";
		} catch (Exception excecao) {
			JSFMessages.exibirMensagem(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro durante o processamento da solicitação.");
			return "cadastro.xhtml";
		}
	}

	public boolean isCadastro() {
		return cadastro;
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
	
	public List<SelectItem> getListaDeCategorias() {
		List<SelectItem> listaDeCategorias = new ArrayList<SelectItem>();
		for (Categoria categoria : daoCategoria.listarTodas()) {
			listaDeCategorias.add(new SelectItem(categoria, categoria.getNome()));
		}
		return listaDeCategorias;
	}

}