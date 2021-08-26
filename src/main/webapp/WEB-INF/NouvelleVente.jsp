<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/styleNouvelleVente.css" />
<title>Nouvelle Enchère</title>
</head>
<body>
<jsp:include page="PageAccueil.jsp"></jsp:include>
<h1 class="TitleNewSell"> Nouvelle vente </h1>
<br>
	<form action="${pageContext.request.contextPath}/venteEnchere" method="post" enctype="multipart/form-data">
	<div class="descriptif">
		<div class="nomArticle">
			<label class="labelNom" for="article">Article :</label> 
			<input class="inputNom" type="text"name="article" required> 
		</div>
		<br>
		<div class="descriptArticle">
			<label class="labelDescript" for="article">Description :</label> 
			<input class="inputDescript" type="text" name="description"/>
		</div> 
		<br>
		<div class="categtArticle">
			<label class="labelCateg" for="categorie">Categorie :</label>
			<select class="selectCateg" name="categories">
			 	<c:forEach items="${listcategory}" var="category">
                	<option value="${category.no_categorie}">
                	    ${category.libelle}
                	</option>
            	</c:forEach>	
			</select>
		</div>
		<br> 
		<div class="photoArticle">
			<label class="labelPhoto" for="photo">Photo de l'article :</label><br>
				<input class="inputPhoto" type="file" accept="image/png,image/jpeg" name="img"><br>
					<img id="uploadPreview" style="width: 100px; height: 100px;"/> 
					<script type="text/javascript"> 
					function PreviewImage() { 
					var oFReader = new FileReader();	 
					oFReader.readAsDataURL(document.getElementById("pictureFile").files[0]); 
					oFReader.onload = function (oFREvent) {
					document.getElementById("uploadPreview").src = oFREvent.target.result; };}; 
					</script>
		</div> 
		<br>
		<div class="MiseAPrixArticle">
			<label class="labelMise" for="miseAPrix">Mise à prix : </label> 
			<input class="inputMise" type="number"name="prix" min="0" max="10000">
		</div>
		<br>
		<div class="DebutEnchereArticle">
			<label class="labelDebut" for="DebutEnchere">Début de l'enchère :</label> 
			<input class="inputDebut" type="datetime-local" name="dateDebut">
		</div>
		<br>
		<div class="FinEnchereArticle">
			<label class="labelFin" for="FinEnchere">Fin de l'enchère :</label> 
			<input class="inputFin" type="datetime-local" name="dateFin">
		</div>
	</div>
	<br>
		<h2 class="TitleRetrait"> Retrait </h2>
			<div class="Retrait">
				<div class="cadreWriteRetrait">
					<div class="rueRetrait">
						<label class="labelRue" for="rue">Rue :</label> 
						<input class="inputRue" type="text" name="rue" required value="${sessionScope.utilisateur.rue}">
					</div>
					<br>
					<div class="cpRetrait"> 
						<label class="labelCp" for="cp">Code postal :</label> 
						<input class="inputCp" type="text" name="cp"required value="${sessionScope.utilisateur.codePostal}">
					</div>
					<br>
					<div class="villeRetrait">
						<label class="labelVille" for="ville">Ville :</label> 
						<input class="inputVille" type="text" name="ville"required value="${sessionScope.utilisateur.ville}">
					</div>
				</div>
				<br>
				<div class="buttonsNewSell">
					<button class="buttonRegister" type="submit">Enregistrer</button>
					<button class="buttonReset" type="reset">Annuler</button>
				</div>
			</div>
	</form>



</body>
</html>