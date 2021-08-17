<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<style>
.erreurmsg{
color: red;
}
</style>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<form action="./Login" method="post">
	<label for="pseudo" class="labelPseudo">Pseudo :</label>
	<input type="text" name="pseudo" class="inputPseudo"/>
	<br />
	<label for="motdepasse" class="labelmdp">Mot de passe : </label>
	<input type="password" class="inputmdp" name="motdepasse"/>
	<c:if test="${!empty erreur}">
		<p class="erreurmsg">${erreur}</p>
	</c:if>
	<br />
	<button type="submit">Se connecter</button>
</form>
</body>
</html>