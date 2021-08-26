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
			<input type="text" name="pseudo" value="${utilisateur.pseudo}" required/>
			<p>${erreurmdpactuel}</p>
			<label for="mdp">Mot de passe actuel</label>
			<input type="password" name="mdp" placeholder="Mot de passe" required/>
			<p>${erreurnvmdp}</p>
			<label for="newmdp">Nouveau mot de passe :</label>
			<input type="password" name="newmdp" placeholder="Nouveau mot de passe" required/>
			<p>${erreurconfmdp}</p>
			<label for="newmdp">Confirmer nouveau mot de passe :</label>
			<input type="password" name="confNewMdp" placeholder="Confirmer mot de passe" required/>
			
			<label></label>
			<p>${erreurnom}</p>
			<label for="nom">Nom :</label>
			<input type="text" name="nom" value="${utilisateur.nom}" required/>
			<p>${erreurprenom}</p>
			<label for="prenom">Prenom :</label>
			<input type="text" name="prenom" value="${utilisateur.prenom}" required/>
			<p>${erreuremail}</p>
			<label for="email">Email :</label>
			<input type="email" name="email" value="${utilisateur.email}" required />

			<label for="tel">n°de téléphone :</label>
			<input type="number" name="tel" value="${utilisateur.telephone}" required maxlength="15"/>

			<label for="rue">Adresse</label>
			<input type="text" name="rue" value="${utilisateur.rue}" required/>

			<label for="cp">Code postal</label>
			<input type="text" name="cp" value="${utilisateur.codePostal}" required maxlength="5"/>
			<p>${erreurville}</p>
			<label for="ville">Ville</label>
			<input type="text" name="ville" value="${utilisateur.ville}" required />

			<button type="submit">Modifier</button>
    </form>
    <a href="./Supprimer">Supprimer</a>
</body>
</html>