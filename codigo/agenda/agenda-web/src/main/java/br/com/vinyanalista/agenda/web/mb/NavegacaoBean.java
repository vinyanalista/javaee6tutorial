package br.com.vinyanalista.agenda.web.mb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class NavegacaoBean {

	public String irParaPaginaInicial() {
		return "/index.xhtml?faces-redirect=true";
	}

}