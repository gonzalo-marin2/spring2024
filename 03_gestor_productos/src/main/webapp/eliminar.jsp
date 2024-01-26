<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h1>Eliminar Producto</h1>
		<form action="eliminar" method="post">
			<input type="text" name="nombre"
				placeholder="Nombre del producto a eliminar"> <input
				type="submit" value="Eliminar">
		</form>
		<br>
		<a href="toMenu">Menú</a>
	</div>

</body>
</html>