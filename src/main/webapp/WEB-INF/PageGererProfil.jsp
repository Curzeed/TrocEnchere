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
			<p >Nom : ---------------- </p>
			<br />
			<p >Prénom : ---------------- </p>
			<br />
			<p >Email : ---------------- </p>
			<br />
			<p >Téléphone : ---------------- </p>
			<br />
			<p >Rue : ---------------- </p>
			<br />
			<p >Code Postal : ---------------- </p>
			<br />
			<p >Ville : ---------------- </p>
			<br />
			<a href="./ModifiersonProfil">Modifier son Profil</a>
		</c:if>
			
		
	</fieldset>
</body>
</html>