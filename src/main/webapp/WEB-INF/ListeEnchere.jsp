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
					<c:if test="">
						<input type="checkbox" id="encheresOuverte" name="encheresOuverte" value="encheresOuverte" >
						<label for="achats">enchères ouvertes</label><br>
						<input type="checkbox" id="mesEncheres" name="mesEncheres" value="mesEncheres" >
						<label for="achats">mes enchères</label><br>
						<input type="checkbox" id="encheresRemporté" name="encheresRemporté" value="encheresRemporté" >
						<label for="achats">mes enchères remportées</label><br>	
					</c:if>
				</fieldset>
				<fieldset>
					
						<input type="radio" id="ventes" name="radiobutton" value="ventes">
						<label for="ventes">Mes ventes</label>
					<c:if test="${!empty ventes}">
						<input type="checkbox" id="ventesEnCours" name="ventesEnCours" value="ventesEnCours" >
						<label for="ventes">mes ventes en cours</label><br>
						<input type="checkbox" id="ventesNomDebutées" name="ventesNomDebutées" value="ventesNomDebutées" >
						<label for="ventes">ventes nom debutées</label><br>
						<input type="checkbox" id="ventesTerminées" name="ventesTerminées" value="ventesTerminées" >
						<label for="ventes">ventes terminées</label><br>
					</c:if>
				</fieldset>
		
				
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