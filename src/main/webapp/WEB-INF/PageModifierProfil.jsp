<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styleModifierProfil.css"/>
<title>Modifier son profil</title>
</head>
<body>
<jsp:include page="PageAccueil.jsp"></jsp:include>
    <h1>Modifier votre Profil</h1>
    <br>
    <form action="./ModifiersonProfil" method="post">
    	<div class="modifProfil">
	    	<div class="firstcolumn"><br>
	    		<div class="pseudo">
		    		<p>${erreurpseudo}</p>
		    		<label for="pseudo">Pseudo :</label>
					<input type="text" name="pseudo" value="${utilisateur.pseudo}" required/>
				</div>
				
				<div class="prenom">
					<p>${erreurprenom}</p>
					<label for="prenom">Prenom :</label>
					<input type="text" name="prenom" value="${utilisateur.prenom}" required/>
				</div>
				<br>
				<div class="tel">
					<label for="tel">N°de téléphone :</label>
					<input type="number" name="tel" value="${utilisateur.telephone}" required maxlength="15"/>
			 	</div>
			 	<br>
			 	<div class="cp">
					<label for="cp">Code postal</label>
					<input type="text" name="cp" value="${utilisateur.codePostal}" required maxlength="5"/>
				</div>
				
				<div class="mdpact">
					<p>${erreurmdpactuel}</p>
					<label for="mdp">Mot de passe actuel</label>
					<input type="password" name="mdp" placeholder="Mot de passe" required/>
				</div>
				
				<div class="mdpnv">
					<p>${erreurnvmdp}</p>
					<label for="newmdp">Nouveau mot de passe :</label>
					<input type="password" name="newmdp" placeholder="Nouveau mot de passe" required/>
				</div>
				<br>
				<div class="credit">
					<label for="credit">Credit :${utilisateur.credit}</label>
				</div>
	    	</div>
	    		
			<div class="secondcolumn">
				
				<div class="nom">
					<p>${erreurnom}</p>
					<label for="nom">Nom :</label>
					<input type="text" name="nom" value="${utilisateur.nom}" required/>
				</div>
				
				<div class="email">
					<p>${erreuremail}</p>
					<label for="email">Email :</label>
					<input type="email" name="email" value="${utilisateur.email}" required />
				</div>
				<br>
				<div class="adresse">
					<label for="rue">Adresse</label>
					<input type="text" name="rue" value="${utilisateur.rue}" required/>
				</div>
				
				<div class="ville">
					<p>${erreurville}</p>
					<label for="ville">Ville</label>
					<input type="text" name="ville" value="${utilisateur.ville}" required />
				</div>
				<div class="vide">
				<br><br>
				
				</div>
				<div class="mdpnvconf">
					<p>${erreurconfmdp}</p>
					<label for="newmdp">Confirmer mot de passe :</label>
					<input type="password" name="confNewMdp" placeholder="Confirmer mot de passe" required/>
				</div>
				
			</div>
		</div>	
			<button type="submit" class="modifButton">Modifier</button>
			<a href="./Supprimer" >Supprimer mon profil</a>
    </form>
    
</body>
</html>