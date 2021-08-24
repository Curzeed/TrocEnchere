<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<form action="./Login" method="post">
	<label for="pseudo" class="labelPseudo">Pseudo ou E-mail :</label>
	<input type="text" name="pseudo" class="inputPseudo" value="${cookie.pseudo.value }" >
	<br />
	<label for="motdepasse" class="labelmdp">Mot de passe : </label>
	<input type="password" class="inputmdp" name="motdepasse"  >
	<c:if test="${!empty erreur}">
		<p class="erreurmsg" style="color : red;">${erreur}</p>
	</c:if>
	<br />
	<button type="submit">Se connecter</button>
	
	<label for="souvenir" class="labelsouvenir">   Se souvenir de moi</label>
	<input type="checkbox" name="souvenir">

</form>
</body>
</html>