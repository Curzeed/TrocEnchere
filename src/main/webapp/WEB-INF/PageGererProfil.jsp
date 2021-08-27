<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styleGererProfil.css" />
<title>Profil</title>
</head>
<body>
<jsp:include page="PageAccueil.jsp"></jsp:include>
<h1 class="TitleMonProfil">Mon Profil</h1>
<div class="Profil">
		<c:if  test="${!empty sessionScope.utilisateur}">
			<p class="Pseudo">PSEUDO : ${sessionScope.utilisateur.pseudo}</p>
			<br />
			<p class="Nom">NOM : ${sessionScope.utilisateur.nom}</p>
			<br />
			<p class="Prenom">PRENOM : ${sessionScope.utilisateur.prenom}</p>
			<br />
			<p class="Email">EMAIL : ${sessionScope.utilisateur.email}</p>
			<br />
			<p class="Telephone">TELEPHONE : ${sessionScope.utilisateur.telephone}</p>
			<br />
			<p class="Rue">RUE : ${sessionScope.utilisateur.rue}</p>
			<br />
			<p class="CodePostal">CODE POSTAL : ${sessionScope.utilisateur.codePostal}</p>
			<br />
			<p class="Ville">VILLE : ${sessionScope.utilisateur.ville}</p>
			<br />
			<a class="buttonModif" href="./ModifiersonProfil">Modifier son Profil</a>
		</c:if>
</div>
</body>
</html>