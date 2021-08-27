<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/stylePageArticle.css"/>
<title></title>
</head>
<body>
<jsp:include page="PageAccueil.jsp"></jsp:include>
	<div>
			<h1>Détail vente : </h1>
			
			<img src="pageContext.request.contextPath}/uploads/${detailArticle.image}" alt="image du produit" />
			
			<p><b>Description :</b> ${detailArticle.description}</p>
			
			<p><b>Catégorie :</b> ${detailArticle.categories.libelle}</p>
			
			<p><b>Meilleure offre :</b> ${detailArticle.enchere.montant_enchere}</p>
			
			<p><b>Mise à prix :</b>  ${detailArticle.prix}</p>
			
			<p><b> Fin de l'enchère :</b> ${detailArticle.dateFin}</p>
			
			<p><b> Retrait :</b> ${sessionScope.utilisateur.rue} <br /> ${sessionScope.utilisateur.ville} <br /> ${sessionScope.utilisateur.codePostal}</p>
			 
			<p><b>Vendeur : </b> ${detailArticle.user.nom} ${detailArticle.user.prenom}</p>
	
	<form action="./DetailArticle" method="post">
		<label for="mise"><b>Ma proposition :</b> </label>
		<input type="number" name="montant"/>
		<input name="idArticle" type="hidden" value="${detailArticle.idArticle}">
		<button type="submit">Enchérir</button>
	</form>
	</div>
</body>
</html>