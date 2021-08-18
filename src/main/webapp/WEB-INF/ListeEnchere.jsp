<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des enchères</title>
</head>
<body>
	<jsp:include page="PageAccueil.jsp"></jsp:include>
	<c:if test="${!empty sessionScope.pseudo}">
		<div>
			<form action="./ListeEnchere">
				<input type="text" placeholder="nom de l'article"/>
				
				
				<label for="categorie">Categorie :</label>
				<select name="categorieOn" id="categorie">
				
					<option value=""> Choisir une catégorie</option><br>
					<option value=""> Jsp</option>
				
				</select>
				<fieldset>
					<input type="radio" id="achats" name="radiobutton" value="achats" >
					<label for="achats">Achats</label><br>
					
				</fieldset>
				
				<input type="radio" id="ventes" name="radiobutton" value="ventes">
				<label for="ventes">Mes Ventes</label><br>
				
				<button type="submit" >Rechercher</button>
			</form>
	    </div>
</c:if>
	
	<c:if test="${empty sessionScope.pseudo}">
		<div>
			<h3>Filtres</h3>
			<form action="./ListeEnchere">
			
			<input type="text" placeholder="nom de l'article"/>
			
			
			<label for="categorie">Categorie :</label>
			<select name="categorie" id="categorie">
			
				<option value=""> Choisir une catégorie</option>
				<option value=""> Jsp</option>
			
			</select>
			
			<button type="submit" >Rechercher</button>
			</form>
		</div>
	</c:if>
	
	
</body>
</html>