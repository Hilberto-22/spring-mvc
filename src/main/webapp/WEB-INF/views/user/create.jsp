<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h1>Cadastro de Usuários</h1>
		<hr>

		<div>
			<spring:url value="/usuario/todos" var="home" />
			<a class="btn btn-default" href="${home}">Lista</a>
		</div>
		<hr>
		<div>
			<spring:url
				value="${usuario.id == null ? '/usuario/save' : '/usuario/update'}"
				var="salvar"></spring:url>
			<form:form modelAttribute="usuario" action="${salvar}" method="post">
				<form:hidden path="id" />
				<div class="form-group">
					<label for="nome">Nome: </label>
					<form:input path="nome" class="form-control" />
					<form:errors path="nome" cssClass="label label-danger"/>
				</div>
				<div class="form-group">
					<label for="sobrenome">Sobrenome: </label>
					<form:input path="sobrenome" class="form-control" />
					<form:errors path="sobrenome" cssClass="label label-danger"/>
				</div>
				<div class="form-group">
					<label for="sexo">Sexo: </label>
					<form:select path="tipoSexo" class="form-control">
						<form:options items="${sexos }" itemLabel="descricao" />
					</form:select>
				</div>
				<div class="form-group">
					<label for="dtNascimento">Data Nascimento: </label>
					<form:input path="dtNascimento" class="form-control" type="date" />
					<form:errors path="dtNascimento" cssClass="label label-danger"></form:errors>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Confirmar</button>
				</div>
			</form:form>
		</div>
		<hr>
		<footer class="footer">
			<p>&copy; 2024</p>
		</footer>
	</div>
</body>
</html>