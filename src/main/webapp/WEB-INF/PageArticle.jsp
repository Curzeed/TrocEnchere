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
<c:forEach items="encheres"  var="t">
<p>Description : ${encheres.t.description}</p>

<p>Catégorie : </p>

<p>Meilleure offre : </p>

<p> Mise à prix : </p>

<p> Fin de l'enchère : </p>

<p> Retrait : </p>

<p> Vendeur :</p>
</c:forEach>
<form action="./DetailArticle" method="post">
	<label for="mise">Ma proposition : </label>
	<input type="number" />
	<button type="submit">Enchérir</button>
</form>
</body>
</html>