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

	<center>
		<form action="buscar" method="GET">
			Introduce categoría: <input type="text" name="categoria"><br><br>
			<input type="submit" value="Enviar">
		</form>
		<br>
		<a href="toMenu">Menú</a>
	</center>

</body>
</html>