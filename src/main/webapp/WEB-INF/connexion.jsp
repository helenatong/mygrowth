<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

<c:if test='${!empty form.loginRespond}'>
<c:if test='${form.loginRespond.equals("Vous êtes bien connecté")}'> 
	<c:out value='${form.loginRespond}'/>
	<c:if test='${!empty sessionScope.name}'>
	<p>
	<a href="/Site/accueil" class = "button">Accueil</a> <br>
	</p>
	</c:if>
</c:if>
</c:if>

<c:if test='${!empty form.loginRespond}'>
<c:if test='${form.loginRespond.equals("Mot de passe incorrect")}'> 
<h6>Veuillez réessayer, le mot de passe c'est votre prenom suivi de 123 sans espace.</h6>
<h1>Portail de connexion</h1>
<form action="connexion" method="post">
	<label for="name">Prénom:</label>
	<input type="text" id="name" name ="name" required> <br> <br>
	
	<label for="pass">Mot de passe:</label>
	<input type="password" id="pass" name="pass" required> <br> <br>

	<input type="submit" value="connexion">
</form>
</c:if>
</c:if>

<c:if test='${empty form.loginRespond}'>
<h1>Portail de connexion</h1>
<form action="connexion" method="post">
	<label for="name">Prénom:</label>
	<input type="text" id="name" name ="name" required> <br> <br>
	
	<label for="pass">Mot de passe:</label>
	<input type="password" id="pass" name="pass" required> <br> <br>

	<input type="submit" value="connexion">
</form>
</c:if>

<ul>
     <c:forEach var="utilisateur" items="${ utilisateurs }">
         <li><c:out value="${ utilisateur.prenom }" /> </li>
     </c:forEach>
</ul>  



</body>
</html>