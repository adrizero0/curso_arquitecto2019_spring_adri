<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
<div class="container">
	<h1>Crear nueva cuenta</h1>
	<f:form action="doAltaCuenta" method="post" modelAttribute="cuentaNueva">
		<div class="form-group">
			<label>Número de cuenta:</label><f:input path="numeroCuenta" class="form-control" style="width:30%" placeholder="Número de cuenta"/>
		</div>
		<div class="form-group">
			<label>Tipo de cuenta:</label><f:input path="tipocuenta" class="form-control" style="width:30%" placeholder="Tipo de cuenta"/>
		</div>	
		<select name="clientes">
			<option value="">Selecciona cliente</option>
			<c:forEach var="c" items="${requestScope.clientesLista}">
				<option value="${c.dni}">${c.nombre}</option>				
			</c:forEach>
				
		</select>
		<button type="submit" class="btn btn-default">Registrar</button>
		
	</f:form>
	
</div>
</body>
</html>