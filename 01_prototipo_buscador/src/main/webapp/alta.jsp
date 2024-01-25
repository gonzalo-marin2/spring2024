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
		<h2>Añadir un nuevo resultado</h2>
		<form action="alta" method="post">
			URL:<input type="text" name="url" placeholder="url"><br>
			Temática:<input type="text" name="tematica" placeholder="Temática"><br>
			Descripción:<input type="text" name="descripcion" placeholder="Descripción"><br>
			<input type="submit" value="Nuevo">
		</form>
		<br>
		<a href="toMenu">Volver</a>
	</div>
</body>
</html>