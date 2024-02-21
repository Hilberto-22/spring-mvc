<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Ususarios</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1>Lista de Usuários</h1>
		<hr>
		<div>
			<spring:url value="/usuario/cadastro" var="cadastro"></spring:url>
			<a class="btn btn-default" href="${cadastro}">Novo Usuário</a>
		</div>
		<hr>

		<div class="${message == null ? 'panel-default' : 'panel-success'}">

			<div class="panel-heading">
				<span>${message == null ? '&nbsp;' : message}</span>
			</div>

			<table class="table table-striped table-condensed">
				<thead class="thead-dark">
					<tr align="center">
						<th>ID</th>
						<th>NOME</th>
						<th>DATA NASCIMENTO</th>
						<th>TIPO SEXO</th>
						<th>AÇÃO</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="usuario" items="${usuarios }">
						<tr align="center">
							<td align="center">${usuario.id }</td>
							<td align="center">${usuario.nome } &nbsp; ${usuario.sobrenome }</td>
							<td align="center"><f:parseDate var="date" value="${usuario.dtNascimento }"
									pattern="yyyy-MM-dd" type="date" /> <f:formatDate
									value="${date }" pattern="dd/MM/yyyy" type="date" /></td>
							<td align="center">${usuario.tipoSexo.descricao}</td>
							<spring:url value="/usuario/update/${usuario.id}" var="update" />
							<td><a class="btn btn-info" href="${update}">Editar</a> <spring:url
									value="/usuario/delete/${usuario.id }" var="delete" /> <a
								class="btn btn-danger" href="${delete}">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr>
		<footer class="footer">
			<p>&copy; 2024</p>
		</footer>
	</div>
</body>
</html>