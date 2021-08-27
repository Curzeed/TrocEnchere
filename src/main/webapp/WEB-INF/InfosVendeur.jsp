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
<jsp:include page="PageAccueil.jsp"></jsp:include>
<fieldset>
		<c:if test="${!empty sessionScope.utilisateur.pseudo}">
			<c:forEach  items="${vendeur}" var="infos">
				<p><b>Pseudo :</b> ${infos.pseudo}</p>
				<br />
				<p ><b>Nom : </b>${infos.nom} </p>
				<br />
				<p ><b>Prénom : </b>${infos.prenom} </p>
				<br />
				<p ><b>Email : </b>${infos.email} </p>
				<br />
				<p ><b>Téléphone : </b>${infos.telephone} </p>
				<br />
				<p ><b>Rue : </b>${infos.rue} </p>
				<br />
				<p ><b>Code Postal : </b>${infos.codePostal} </p>
				<br />
				<p ><b>Ville : </b>${infos.ville} </p>
				<br />
			</c:forEach>
		</c:if>
			<c:if test="${empty sessionScope.utilisateur.pseudo}">
				<p> Il faut être connecté pour voir ces informations</p>
			</c:if>
		
	</fieldset>
</body>
</html>