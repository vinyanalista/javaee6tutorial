package br.com.vinyanalista.agenda.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vinyanalista.agenda.modelo.Contato;

public class ListaContatosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest requisicao,
			HttpServletResponse resposta) throws ServletException,
			IOException {
		resposta.setContentType("text/html");
		PrintWriter saida = resposta.getWriter();

		saida.println("<html>");
		saida.println("<head>");
		saida.println("<title>Agenda de Contatos</title>");
		saida.println("</head>");
		saida.println("<body>");
		saida.println("<h1>Agenda de Contatos</h1>");
		saida.println("<hr />");

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

		saida.println("<table border='1'>");
		saida.println("<tr>");
		saida.println("<th>Nome</th>");
		saida.println("<th>Telefone</th>");
		saida.println("<th>E-mail</th>");
		saida.println("</tr>");

		for (Contato contato : contatos) {
			saida.println("<tr>");
			saida.println("<td>" + contato.getNome() + "</td>");
			saida.println("<td>" + contato.getTelefone() + "</td>");
			saida.println("<td>" + contato.getEmail() + "</td>");
			saida.println("</tr>");
		}

		saida.println("</table>");
		saida.println("<hr />");
		saida.println("<i>Desenvolvimento de Aplicações Corporativas "
				+ "com a Plataforma Java EE 6</i>");
		saida.println("</body>");
		saida.println("</html>");

		saida.close();
	}
}