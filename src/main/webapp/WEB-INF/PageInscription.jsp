<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styleInscription.css"/>
<title>Inscription</title>
</head>
<body>
<jsp:include page="PageAccueil.jsp"></jsp:include>
<h1>Formulaire d'inscription :</h1>
<form action="./Inscription" method="post">
<fieldset>
<legend>S'inscrire</legend>
<p>${erreurpseudo}</p>
<div class="cadreWriteInscription">
	<div class="pseudo">
		<label for="pseudo">Pseudo :</label>
		<input type="text" name="pseudo" placeholder="Votre pseudo" required/>
	</div>
	<br>
	<div class="mdp">
		<label for="mdp">Mot de passe :</label>
		<input type="password" name="mdp" placeholder="Votre mot de passe" required/>
	</div>
	<br>
	<div class="mdpConfirm">
		<label for="mdp">Confirmation :</label>
		<input type="password" name="mdpConfirm" placeholder="Votre mot de passe" required/>
	</div>
	<br>
	<div class="surname">
		<label for="nom">Nom :</label>
		<input type="text" name="nom" placeholder="Votre nom" required/>
		<p>${erreurnom}</p>
	</div>
	<br>
	<div class="firstname">
		<label for="prenom">Prenom :</label>
		<input type="text" name="prenom" placeholder="Votre prenom" required/>
		<p>${erreurprenom}</p>
	</div>
	<br>
	<div class="email">
		<label for="email">Email :</label>
		<input type="email" name="email" placeholder="Votre email" required/>
		<p>${erreuremail}</p>
	</div>
	<br>
	<div class="phone">
		<label for="tel">N°de téléphone :</label>
		<input type="tel" name="tel" placeholder="Votre téléphone" required/>
	</div>
	<br>
	<div class="adress">
		<label for="rue">Adresse</label>
		<input type="text" name="rue" placeholder="Votre adresse" required/>
	</div>
	<br>
	<div class="postalCode">
		<label for="cp">Code postal</label>
		<input type="text" name="cp" placeholder="Votre code postal" required/>
		<p>${erreurville}</p>
	</div>
	<br>
	<div class="Town">	
		<label for="ville">Ville</label>
		<input type="text" name="ville" placeholder="Votre ville" required/>
	</div>
	<br>
</div>
<button type="submit" class="createButton">S'inscrire</button>
<a href="./ListeEnchere" class="cancelButton">Annuler</a>

<br>
<div class="errorMessage">
	<c:if test="${!empty erreur}">	
		 <p style="color : red;"><c:out value="${erreur}"/></p>
	</c:if>
</div>
</fieldset>
</form>
</body>
</html>