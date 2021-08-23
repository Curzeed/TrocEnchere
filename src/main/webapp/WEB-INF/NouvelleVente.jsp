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


	<form action="./venteEnchere" method="post">

		<label for="article">Article :</label> 
		<input type="text"name="article" required><br> 
		<label for="article">Description :</label> 
		<input type="text" name="description"/> 
		<label for="categorie">Categorie :</label>
		<select name="categorie" id="categorie">

			<option value="" >Choisir une catégorie</option>
			<option value="antiquite">Archéologie-Antiquité</option>
			<option value="argenterie">Argenterie-Orfèvrerie</option>
			<option value="electromenager">Electroménager</option>
			<option value="jouet">Jouets</option>
			<option value="jeuxVideo">Jeux vidéo-Consoles</option>
			<option value="livre">Livres</option>
			<option value="mobilier">Mobilier</option>
			<option value="musique">Musique-CD-Vinyles</option>
			<option value="objetArt">Objet-Art</option>
			<option value="sculptures">Sculptures</option>
			<option value="sport">Sport</option>
			<option value="tableau">Tableau</option>
			<option value="vin">Vins-Spiritueux</option>
		
		</select><br> <label for="photo">Photo de l'article</label> <input
			type="file" accept="image/png,image/jpeg" name="img">
			<img id="uploadPreview" style="width: 100px; height: 100px;"/> 
			<script type="text/javascript"> 
			function PreviewImage() { 
			var oFReader = new FileReader();	 
			oFReader.readAsDataURL(document.getElementById("pictureFile").files[0]); 
			oFReader.onload = function (oFREvent) {
			document.getElementById("uploadPreview").src = oFREvent.target.result; };}; 
			</script> <br>
			
		<label for="miseAPrix">Mise à prix : </label> <input type="number"
			name="prix" min="0" max="10000"><br> <label
			for="DebutEnchere">Début de l'enchère :</label> <input
			type="datetime" name="dateDebut"><br> <label
			for="FinEnchere">Fin de l'enchère :</label> <input
			type="datetime" name="dateFin"><br>

		<fieldset>
			<legend>Retrait</legend>
			<label for="rue">Rue :</label> 
			<input type="text" name="rue" required value="${sessionScope.utilisateur.rue}"><br> 
			<label for="cp">Code postal :</label> 
			<input type="text" name="cp"required value="${sessionScope.utilisateur.codePostal}"><br>

			<label for="ville">Ville :</label> 
			<input type="text" name="ville"required value="${sessionScope.utilisateur.ville}"><br>

			<button type="submit">Enregistrer</button>
			<button type="reset">Annuler</button>
		</fieldset>


	</form>



</body>
</html>