<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<style type="text/css">
	.odd {
		background-color: #CCE5FF;
	}
</style>
</head>
<body>
	<c:import url="../../cabecalho.jsp"></c:import>
		
		<!-- 
		<display:table name="${dao.lista}" export="false" id="contato" class="table">
            <display:column title="Nome">
            	<c:out value="${contato.nome}"></c:out>
            </display:column>	
              
            <c:choose>  
                <c:when test="${not empty contato.email}">  
                    <display:column title="E-mail" property="email" autolink="true" />  
                </c:when>  
                <c:otherwise>  
                    <display:column title="E-mail" value="E-mail não informado" />  
                </c:otherwise>  
            </c:choose>  
              
            <display:column title="Endereço" property="endereco" />  
              
            <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" var="dataEmTexto"/>  
            <display:column title="Data de nascimento" value="${dataEmTexto}" />  
              
        </display:table> 
		 -->
		 
		<table class="table">
			<thead>
				<tr>
					<td>Nome</td>
					<td>Email</td>
					<td>Endereço</td>
					<td>Data Nascimento</td>
					<td>Remover</td>
					<td>Editar</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="contato" items="${contatos}" varStatus="id">
					<tr class="${id.count % 2 == 0 ? '' : 'odd'}">
						<td><c:out value="${contato.nome}"></c:out></td>
						<td>
							<c:choose>
								<c:when test="${not empty contato.email }">
									<a href="mailto:${contato.email}">${contato.email}</a>
								</c:when>
								<c:otherwise>
									E-mail não informado.
								</c:otherwise>
							</c:choose>
						</td>
						<td>${contato.endereco}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy" value="${contato.dataNascimento.time}" /></td>
						<td>
							<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
						</td>
						<td>
							<a href="mvc?logica=EditaContatoLogic&id=${contato.id}">Editar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<c:import url="../../rodape.jsp"></c:import>
</body>
</html>