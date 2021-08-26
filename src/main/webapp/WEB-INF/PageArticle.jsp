<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<jsp:include page="PageAccueil.jsp"></jsp:include>
<h1>Détail vente : </h1>

<img src="pageContext.request.contextPath}/uploads/${detailArticle.image}" alt="image du produit" />

<p>Description : ${detailArticle.description}</p>

<p>Catégorie : ${detailArticle.categories.libelle}</p>

<p>Meilleure offre : ${detailArticle.enchere.montant_enchere}</p>

<p> Mise à prix : ${detailArticle.prix}</p>

<p> Fin de l'enchère : ${detailArticle.dateFin}</p>

<p> Retrait : ${sessionScope.utilisateur.rue} <br /> ${sessionScope.utilisateur.ville} <br /> ${sessionScope.utilisateur.codePostal}</p>
 
<p> Vendeur : ${detailArticle.user.nom} ${detailArticle.user.prenom}</p>

<form action="./DetailArticle" method="post">
	<label for="mise">Ma proposition : </label>
	<input type="number" name="montant"/>
	<input name="idArticle" type="hidden" value="${detailArticle.idArticle}">
	<button type="submit">Enchérir</button>
</form>
</body>
</html>