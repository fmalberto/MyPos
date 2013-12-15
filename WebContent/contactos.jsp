<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes</title>
</head>
<body>
	<center>
		<table border="1">
			<tr>
				<td>Nome</td>
				<td>Apelido</td>
				<td>Idade</td>
				<td>Telefone</td>
				<td>Cidade</td>
			</tr>

			<c:forEach items="${contactoList}" var="contacto"> 
				<tr>
					<td>${contacto.nombre}</td>
					<td>${contacto.apellido}</td>
					<td>${contacto.edad}</td>
					<td>${contacto.telefono}</td>
					<td>${contacto.ciudad}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>