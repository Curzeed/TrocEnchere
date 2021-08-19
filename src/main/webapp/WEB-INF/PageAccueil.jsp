<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styleAccueil.css" />
<title>Accueil</title>
</head>
<body>
<header>
<c:if test="${!empty sessionScope.utilisateur}">
   <div>
	<p>Vous êtes connectés au nom de : ${sessionScope.utilisateur.prenom} ${sessionScope.utilisateur.nom} </p>
	<a href="./Deconnexion"> Déconnexion </a>
	<a href="./MonProfil"> Gérer mon profil </a>
	<a href="./venteEnchere"> Vendre un article</a>
	
   </div>
</c:if>
	
	<c:if test="${empty sessionScope.utilisateur}">
		<div class="offline-buttons">
				<a href="./Login">login</a><br />
				<a href="./Inscription">Inscription</a>
			
		</div>
	</c:if>
</header>

</body>
</html>