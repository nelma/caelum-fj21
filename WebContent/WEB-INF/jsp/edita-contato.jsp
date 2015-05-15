<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="../../cabecalho.jsp"></c:import>
	<form action="mvc?logica=AtualizaContatoLogic" method="post">
	
		<input type="hidden" id="idContato" name="id" value="${contato.id}">
	
		Nome: <input type="text" name="nome" value="${contato.nome}">
		<br>
		E-mail: <input type="text" name="email" value="${contato.email}">
		<br>
		Endereço: <input type="text" name="endereco" value="${contato.endereco}">
		<br>
		
		<fmt:formatDate pattern="dd-MM-yyyy" value="${contato.dataNascimento.time}" var="formatedDate" />
		Data Nascimento: <caelum:campoData id="dataNascimento" value="${formatedDate}" />
		<br>
		
		<input type="submit" value="Edita">
	</form>
	<c:import url="../../rodape.jsp"></c:import>
</body>
</html>