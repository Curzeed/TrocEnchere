<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier son profil</title>
</head>
<body>
<jsp:include page="PageAccueil.jsp"></jsp:include>
    <h1>Modifier votre Profil</h1>
    <br>
    <form action="./ModifiersonProfil" method="post">
    		
    		<p>${erreurpseudo}</p>
    		<label for="pseudo">Pseudo :</label>
			<input type="text" name="pseudo" placeholder="${utilisateur.pseudo}" />
			
			<label for="mdp">Mot de passe :</label>
			<input type="password" name="mdp" placeholder="Nouveau mot de passe" />
			<p>${erreurnom}</p>
			<label for="nom">Nom :</label>
			<input type="text" name="nom" placeholder="${utilisateur.nom}" />
			<p>${erreurprenom}</p>
			<label for="prenom">Prenom :</label>
			<input type="text" name="prenom" placeholder="${utilisateur.prenom}" />
			<p>${erreuremail}</p>
			<label for="email">Email :</label>
			<input type="email" name="email" placeholder="${utilisateur.email}"  />

			<label for="tel">n°de téléphone :</label>
			<input type="number" name="tel" placeholder="${utilisateur.telephone}"  maxlength="15"/>

			<label for="rue">Adresse</label>
			<input type="text" name="rue" placeholder="${utilisateur.rue}" />

			<label for="cp">Code postal</label>
			<input type="text" name="cp" placeholder="${utilisateur.codePostal}"  maxlength="5"/>
			<p>${erreurville}</p>
			<label for="ville">Ville</label>
			<input type="text" name="ville" placeholder="${utilisateur.ville}"  />

			<button type="submit">Modifier</button>
    </form>
    <a href="./Supprimer">Supprimer</a>
</body>
</html>