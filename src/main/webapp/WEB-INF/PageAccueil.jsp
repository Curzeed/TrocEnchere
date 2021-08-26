<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/stylePageAccueil.css" />
<title>Accueil</title>
</head>
<body>
<header>
<div class="HeaderAccueil">
	<img class="LogoENI_Enchere" src="pictures/logoENI_enchere.png" alt="LogoENI_Enchere">
	<div class="middlestyle">
	<a class="button-home" href="./ListeEnchere">Accueil</a>
	<h1 class="titreSite">ENI-ENCHERES</h1>
	<c:if test="${!empty sessionScope.utilisateur}">
	
	<div class="online_buttons"> 
		<p class="messageConnected">Vous êtes connectés au nom de : ${sessionScope.utilisateur.prenom} ${sessionScope.utilisateur.nom} </p>
		<div class="little-buttons">
			<a class="button-disconnect" href="./Deconnexion"> Déconnexion </a>
			<a class="button-myProfil"href="./MonProfil"> Gérer mon profil </a>
			<a class="button-sellAnArcticle" href="./venteEnchere"> Vendre un article</a>
		</div>
   </div>
</c:if>
	
	<c:if test="${empty sessionScope.utilisateur}">
		<div class="offline-buttons">
			<a class= "button-login" href="./Login">Se connecter</a><br/>
			<a class= "button-signup" href="./Inscription">S'incrire</a>
			
		</div>
	</c:if>
	</div>
</div>
</header>

</body>
</html>