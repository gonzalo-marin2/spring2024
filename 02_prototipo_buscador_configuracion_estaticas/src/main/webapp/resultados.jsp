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
	<c:forEach var="r" items="${resultados}">
		<h2><a href="${r.url}">${r.url}</a></h2>
		<h4>${r.descripcion}</h4>
		<hr>
	</c:forEach>
	<br>
	<a href="toBuscar">Volver</a>
</body>
</html>