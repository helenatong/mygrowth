<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

<h1>Testing BBD</h1>
<form action="sql" method="post">
	<label for="name">Prénom:</label>
	<input type="text" id="name" name ="name" required> <br> <br>
	
	<input type="submit" value="connexion">
</form>

<ul>
     <c:forEach var="utilisateur" items="${ utilisateurs }">
         <li><c:out value="${ utilisateur.prenom }" /> </li>
     </c:forEach>
</ul>  



</body>
</html>