//https://docs.jboss.org/author/display/AS71/EJB+invocations+from+a+remote+client+using+JNDI

package br.com.vinyanalista.agenda.cliente;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.vinyanalista.agenda.dao.ContatoDAO;
import br.com.vinyanalista.agenda.dao.ContatoDAORemote;
import br.com.vinyanalista.agenda.modelo.Contato;

public class Cliente {
	public static void main(String[] args) throws Exception {
		// Cria uma nova instância do contato
		Contato contato = new Contato();
		contato.setNome("Jose");
		contato.setTelefone("1212345678");

		// Obtém o DAO
		ContatoDAORemote dao = obterDaoRemoto();

		// Insere o contato na base de dados
		contato = dao.inserir(contato);
	}

	private static ContatoDAORemote obterDaoRemoto() throws NamingException {
		Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		Context context = new InitialContext(jndiProperties);

		String appName = "";
		String moduleName = "exemplo07";
		String distinctName = "";
		String beanName = ContatoDAO.class.getSimpleName();
		String viewClassName = ContatoDAORemote.class.getName();

		return (ContatoDAORemote) context.lookup("ejb:" + appName + "/"
				+ moduleName + "/" + distinctName + "/" + beanName + "!"
				+ viewClassName);

		// ejb:exemplo07/ContatoDAO!br.com.vinyanalista.agenda.dao.ContatoDAORemote
	}
}