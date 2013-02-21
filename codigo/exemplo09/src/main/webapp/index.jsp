<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="br.com.vinyanalista.agenda.modelo.Contato"%>
<html>
<head>
<title>Agenda de Contatos</title>
</head>
<body>
	<h1>Agenda de Contatos</h1>
	<hr />
	<%
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
	%>
	<table border='1'>
		<tr>
			<th>Nome</th>
			<th>Telefone</th>
			<th>E-mail</th>
		</tr>
		<%
			for (Contato contato : contatos) {
		%>
		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getTelefone()%></td>
			<td><%=contato.getEmail()%></td>
		</tr>
		<%
			}
		%>

	</table>
	<hr />
	<i>Desenvolvimento de Aplicações Corporativas com a Plataforma Java
		EE 6</i>
</body>
</html>