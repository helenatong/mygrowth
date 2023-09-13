<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidatures</title>
</head>
<body>
<c:if test='${!empty fileCV}'>
<h2><strong>You're awesome. <br> 
<em>"Only actions bring results"</em></strong></h2> <br>
<c:out value ='Votre document nommé ${descriptionCV} a bien été transmis, nous vous recontacterons sous 48h !'> </c:out> <br><br>
</c:if>


<c:if test='${empty fileCV}'>
<h2>"Celui qui <strong>ose</strong> est <em>unstoppable"</em></h2> <br>
<form method="post" action="nousRejoindre" enctype="multipart/form-data">
		
	<label for="fileCV">Déposer mon CV</label>
	<input type="file" name="fileCV" id="fileCV" value="Choisir mon fichier"/> <br><br>
	
	<label for="descriptionCV">Nom du fichier</label>
	<input type="text" name="descriptionCV" id="descriptionCV"/> <br><br>

	<input type="submit" value ="Envoyer" />
</form>
</c:if>
</body>
</html>