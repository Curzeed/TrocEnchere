<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styleLogin.css"/>
<title>Login</title>
</head>
<body>
	<div class="HeaderLogin">
		<img src="pictures/logoENI_enchere.png" alt="LogoENI_Enchere">
		<a class="button-home" href="./Accueil">Accueil</a>
		<h1>ENI-ENCHERES</h1>
	</div>
		<form class="cadreid" action="./Login" method="post">
		<div class="cadreWrite">
			<div class="stylePseudo">
			<label for="pseudo" class="labelPseudo">Pseudo ou E-mail :</label>
			<input type="text" name="pseudo" class="inputPseudo"/>
			</div>
			<br />
			<div class="blockMdp">
				<div class="styleMdp">
					<label for="motdepasse" class="labelmdp">Mot de passe : </label>
					<input type="password" class="inputmdp" name="motdepasse"/>
				</div>
				<c:if test="${!empty erreur}">
					<p class="erreurmsg" style="color : red;">${erreur}</p>
				</c:if>
			
			</div>
		</div>
			<br />
			<div class="blockresult">
				<button type="submit" class="buttonconnect">Se connecter</button>
				<div class="blockStyleNoMdp">
					<div class="rememberMe">
						<input type= "checkbox" name= "rememberMeCheck" class="rememberMeCheck"/>
						Se souvenir de moi
					</div>
					<a class="buttonMdpLost" href="./MdpLost">Mot de passe oublié</a>
				</div>
			</div>
			<a class="createAccount" href="./Inscription">Créer un compte</a>
			
		</form>
</body>
</html>