<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Informations du vendeur</title>
</head>
<body>
<fieldset>
		
			<c:forEach  items="${vendeur}" var="infos">
				<p>Pseudo : ${infos.pseudo}</p>
				<br />
				<p >Nom : ${infos.nom} </p>
				<br />
				<p >Prénom : ${infos.prenom} </p>
				<br />
				<p >Email : ${infos.email} </p>
				<br />
				<p >Téléphone : ${infos.telephone}) </p>
				<br />
				<p >Rue : ${infos.rue} </p>
				<br />
				<p >Code Postal : ${infos.codePostal} </p>
				<br />
				<p >Ville : ${infos.ville} </p>
				<br />
			</c:forEach>
		
			<c:if test="${sessionScope.utilisateur.pseudo}">
				<p> Il faut être connecté pour voir ces informations</p>
			</c:if>
		
	</fieldset>
</body>
</html>