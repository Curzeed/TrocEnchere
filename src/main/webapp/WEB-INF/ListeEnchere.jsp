<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styleListeEnchere.css"/>
<title>Liste des enchères</title>
</head>
<body>
	<jsp:include page="PageAccueil.jsp"></jsp:include>
	<h1 class="titleListEnch">Liste des enchères :</h1>
		<div>
			<form action="./ListeEnchere" method="post">
			<div class="categories">
				<label for="categorieS">Categorie :</label>
					<select name="categories" id="">
			 			<c:forEach items="${listcategory}" var="category">
                			<option value="${category.no_categorie}">
                   				 ${category.libelle}
                			</option>
                
            			</c:forEach>	
					</select>
			</div>
			<br> 
				
			<c:if test="${!empty sessionScope.utilisateur.pseudo}">
				 
			<div class="form-check">
		<label class="form-check-label"> <input type="radio"
			class="form-check-input" name="type-encheres" value="achats"
			id="achats">Achats
		</label>
	</div>
	<div class="form-group">
		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input" name="encheres"
				value="ouvertes" id="ouvertes">Enchères ouvertes
			</label>
		</div>
		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input"
				name="encheres" value="encours" id="encours">Mes enchères en cours
			</label>
		</div>
		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input"
				name="encheres" value="remportees" id="remportees">Mes enchères
				remportées
			</label>
		</div>
	</div>
	<div class="form-check">
		<label class="form-check-label"> <input type="radio"
			class="form-check-input" name="type-encheres"
			value="ventes" id="ventes">Ventes
		</label>
	</div>
	<div class="form-group">
		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input"
				name="ventes" value="venteencours" id="venteencours">Mes ventes en
				cours
			</label>
		</div>
		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input"
				name="ventes" value="nondebutees" id="nondebutees">Mes ventes non
				débutées
			</label>
		</div>
		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input"
				name="ventes" value="terminees" id="terminees">Mes ventes terminées
			</label>
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
			'use strict';

			window
					.addEventListener(
							'load',
							function() {
								checkAchats();
								checkVentes();
								achats.addEventListener('change', function(
										event) {
									checkAchats();
								}, false);
								ventes.addEventListener('change', function(
										event) {
									checkVentes();
								}, false);

								function checkAchats() {
									//id radio button achats
									var achats = document
											.getElementById('achats');
									if (achats.checked) {
										//id des checkbox
										document.getElementById('venteencours').disabled = true;
										document.getElementById('nondebutees').disabled = true;
										document.getElementById('terminees').disabled = true;
										document.getElementById('encours').disabled = false;
										document.getElementById('ouvertes').disabled = false;
										document.getElementById('remportees').disabled = false;
									}
								}
								function checkVentes() {
									//id radio button ventes
									var ventes = document
											.getElementById('ventes');
									if (ventes.checked) {
										//id des checkbox
										document.getElementById('venteencours').disabled = false;
										document.getElementById('nondebutees').disabled = false;
										document.getElementById('terminees').disabled = false;
										document.getElementById('encours').disabled = true;
										document.getElementById('ouvertes').disabled = true;
										document.getElementById('remportees').disabled = true;
									}
								}
							}, false);
		})();
	</script>
				</c:if>
				
				<button class="search" type="submit" >Rechercher</button>
			</form>
	    </div>
	    <div>
	    	<h2 class="titleEnch"> Enchères : </h2>
	    		<c:forEach items="${encheres}" var="liste">
	    				<article> 
	    					<c:if test="${!empty sessionScope.utilisateur.pseudo}"> 
	    					<a href="./DetailArticle">${liste.article}</a>
	    					</c:if>
	    					<c:if test="${empty sessionScope.utilisateur.pseudo}">
	    					${liste.article}
	    					</c:if>
	    					${liste.prix_vente}
	    					<img src="${liste.image}" alt="" />
	    					${liste.dateFin}
	    					<%-- <a href="./ProfilUtilisateur?=${liste.article.idVendeur}">${liste.user.pseudo}</a> --%>
	    				</article>    		
	    		</c:forEach>
	    </div>
</body>
</html>