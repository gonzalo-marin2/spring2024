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
		<h2>Añadir un nuevo producto</h2>
		<form action="alta" method="post">
			Nombre:<input type="text" name="nombre" placeholder="Nombre"><br>
			Precio:<input type="text" name="precio" placeholder="Precio"><br>
			Categoría:<input type="text" name="categoria" placeholder="Categoría"><br>
			<input type="submit" value="Nuevo">
		</form>
		<a href="toMenu">Menú</a>
	</div>
</body>
</html>