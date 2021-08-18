<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" />
<title>Accueil</title>
</head>
<body>
<header>
<c:if test="${!empty sessionScope.pseudo}">
   <div>
	<p>Vous êtes connectés au nom de : ${sessionScope.pseudo} </p>
	<a href="./Deconnexion"> Déconnexion </a>
	<a href="./Modifier"> Modifier </a>
	<a href="./gererProfil"> Gérer mon profil </a>
	<a href="./venteEnchere"> Vendre un article</a>
	
   </div>
</c:if>
	
	<c:if test="${empty sessionScope.pseudo}">
		<div>
				<a href="./Login">login</a><br />
				<a href="./Inscription">Inscription</a>
			
		</div>
	</c:if>
</header>

</body>
</html>