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

<img src="" alt="" />

<p>Description : ${encheres.description}</p>

<p>Catégorie : ${encheres.categorie}</p>

<p>Meilleure offre : ${encheres.enchere.montant_enchere}</p>

<p> Mise à prix : ${encheres.prix_vente}</p>

<p> Fin de l'enchère : ${encheres.dateFin}</p>

<p> Retrait : ${sessionScope.utilisateur.rue} <br />
${sessionScope.utilisateur.codePostal} <br />
${sessionScope.utilisateur.ville}
</p>

<p> Vendeur : ${encheres.user.pseudo}</p>

<form action="./DetailArticle" method="post">
	<label for="mise">Ma proposition : </label>
	<input type="number" />
	<button type="submit">Enchérir</button>
</form>
</body>
</html>