<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" />
<title>Profil</title>
</head>
<body>
    <jsp:include page="PageAccueil.jsp"></jsp:include>


	<fieldset>
		<c:if test="${!empty sessionScope.utilisateur}">
			<p>Pseudo : ${sessionScope.utilisateur.pseudo}</p>
			<br />
			<p >Nom :${sessionScope.utilisateur.nom}</p>
			<br />
			<p >Prénom :${sessionScope.utilisateur.prenom}</p>
			<br />
			<p >Email :${sessionScope.utilisateur.email}</p>
			<br />
			<p >Téléphone :${sessionScope.utilisateur.telephone}</p>
			<br />
			<p >Rue :${sessionScope.utilisateur.rue}</p>
			<br />
			<p >Code Postal :${sessionScope.utilisateur.codePostal}</p>
			<br />
			<p >Ville :${sessionScope.utilisateur.ville}</p>
			<br />
			<a href="./ModifiersonProfil">Modifier son Profil</a>
		</c:if>
			
		
	</fieldset>
</body>
</html>