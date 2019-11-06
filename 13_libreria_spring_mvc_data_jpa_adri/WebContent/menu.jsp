<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Bienvenido:${sessionScope.cliente.usuario}</h1>
		<br/><br/>
		<a href="toTemas">Ver libros</a>
		<br/><br/>
		<a href="toVentas">Ver mis compras</a>
		<br/><br/>
	</center>
</body>
</html>