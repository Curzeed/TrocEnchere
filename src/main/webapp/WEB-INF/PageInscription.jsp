<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
<h1> Formulaire d'inscription</h1>
<form action="./Inscription" method="post">
<label for="pseudo">Pseudo :</label>
<input type="text" name="pseudo" placeholder="Votre pseudo" required/>

<label for="mdp">Mot de passe :</label>
<input type="password" name="mdp" placeholder="Votre mot de passe" required/>

<label for="nom">Nom :</label>
<input type="text" name="nom" placeholder="Votre nom" required/>

<label for="prenom">Prenom :</label>
<input type="text" name="prenom" placeholder="Votre prenom" required/>

<label for="email">Email :</label>
<input type="email" name="email" placeholder="Votre email" required/>

<label for="tel">n°de téléphone :</label>
<input type="tel" name="tel" placeholder="Votre téléphone" required/>

<label for="rue">Adresse</label>
<input type="text" name="rue" placeholder="Votre adresse" required/>

<label for="cp">Code postal</label>
<input type="text" name="cp" placeholder="Votre code postal" required/>

<label for="ville">Ville</label>
<input type="text" name="ville" placeholder="Votre ville" required/>
</form>
</body>
</html>