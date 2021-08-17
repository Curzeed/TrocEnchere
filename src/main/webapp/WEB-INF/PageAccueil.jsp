<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" />
<title>Acceuil</title>
</head>
<body>
<header>
<c:if test="${!empty sessionScope.pseudo}">
	<p>Vous êtes connectés au nom de : ${sessionScope.pseudo} </p>
	<a href="./Deconnexion">Déconnexion</a>
	<a href="./Modifier">Modifier </a>
</c:if>
	<h1>Page d'accueil</h1>
	<c:if test="${empty sessionScope.pseudo}">
		<div>
				<a href="./Login">login</a><br />
				<a href="./Inscription">Inscription</a>
			
		</div>
	</c:if>
</header>

</body>
</html>