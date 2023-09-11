<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:if test='${!empty myAccount.isPositive}'>
<c:choose>
    <c:when test='${myAccount.saving == 0}'>
        <h2>Ok tu es à l'équilibre !</h2>
    </c:when>
        <c:when test='${myAccount.saving > 0}'>
        <h2> Super ! Tu as économisé 
		<c:out value='${myAccount.saving}'/> €
		</h2>
    </c:when>
    <c:otherwise>
        <h2> Mince ! Tu es dans le rouge de
		<c:out value='${myAccount.saving}'/> € <br>
		</h2>
    </c:otherwise>
</c:choose>
</c:if>

<c:if test='${!empty myAccount.isPositive}'>
	<br> <a href="/Site/calculateur" class = "button">Recalculer</a> <br><br>
	<a href="/Site/accueil" class = "button">Revenir à l'accueil</a> <br>
</c:if>

<c:if test='${empty myAccount.isPositive}'>
<h2> Calculons un peu tes ressources !!</h2> <br>
<form action="/Site/calculateur" method="post">
	<label for="income">Revenus</label>
	<input type="number" id="income" name="income" required><br><br>

	<label for="expense">Dépenses</label>
	<input type="number" id="expense" name="expense" required><br><br>

	<input type="submit" value="Calculer">
</form>
</c:if>