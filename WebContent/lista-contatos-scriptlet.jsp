<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body>
	<%@ page import="java.util.*, 
		br.com.caelum.agenda.dao.*,
		br.com.caelum.agenda.modelo.*" %>

	<table class="table">
		<thead>
			<tr>
				<td>Nome</td>
				<td>Email</td>
				<td>Endereço</td>
				<td>Data Nascimento</td>
			</tr>
		</thead>
		<tbody>
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			
			for(Contato contato : contatos) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		%>
			<tr>
				<td><%=contato.getNome() %></td>
				<td><%=contato.getEmail() %></td>
				<td><%=contato.getEndereco() %></td>
				<td><%=dateFormat.format(contato.getDataNascimento().getTime()) %></td>
			</tr>
		<% 	} %>
		</tbody>
	</table>
</body>
</html>