package br.com.vinyanalista.agenda.web.converter;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.vinyanalista.agenda.dao.CategoriaDAOLocal;
import br.com.vinyanalista.agenda.modelo.Categoria;

@ManagedBean
@FacesConverter(value = "categoriaConverter")
public class CategoriaConverter implements Converter {

	private static final String MENSAGEM_DE_ERRO = "Erro durante a conversão da categoria!";

	@EJB
	private CategoriaDAOLocal daoCategoria;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Categoria categoria = null;
		try {
			categoria = daoCategoria.buscar(Integer.parseInt(arg2));
		} catch (Throwable ex) {
			FacesMessage facesMessage = new FacesMessage(MENSAGEM_DE_ERRO);
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(facesMessage);
		}
		return categoria;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		String valor = null;
		if (arg2 != null) {
			try {
				Categoria categoria = (Categoria) arg2;
				valor = Integer.toString(categoria.getId());
			} catch (Throwable ex) {
				FacesMessage facesMessage = new FacesMessage(MENSAGEM_DE_ERRO);
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ConverterException(facesMessage);
			}
		}
		return valor;
	}

}