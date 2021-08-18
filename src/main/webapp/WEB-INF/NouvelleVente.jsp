<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="PageAccueil.jsp"></jsp:include>
<h1>Nouvelle vente </h1><br>
<form action="./ServletVenteEnchere" method="post">

<label for="article">Article :</label>
<input type="text" name="article" required><br>

<label for="article">Description :</label>
<textarea  name="description" rows="7" cols="10" required> </textarea><br>

<label for="categorie">Categorie :</label>
				<select name="categorie" id="categorie">
				
					<option value=""> Choisir une catégorie</option>
					<option value=""> Jsp</option>
				
				</select><br>
<label for="photo">Photo de l'article</label>
<input type="file" accept="image/png,image/jpeg"><br>	

<label for="miseAPrix">Mise à prix : </label>
<input type="number" name="number" min="0" max="10000"><br>	

<label for="DebutEnchere">Début de l'enchère :</label>
<input type="datetime-local" name="dateDebut"><br>	

<label for="FinEnchere">Fin de l'enchère :</label>
<input type="datetime-local" name="dateFin"><br>	

<fieldset>
	<legend>Retrait</legend>
	<label for="rue" >Rue :</label>
	<input type="text" name="rue" required><br>
	
	<label for="cp" >Code postal :</label>
	<input type="text" name="cp" required><br>
	
	<label for="ville" >Ville :</label>
	<input type="text" name="ville" required><br>

	<button type="submit" >Enregistrer  </button>
	<button type="reset"> Annuler </button>
</fieldset>


</form>



</body>
</html>