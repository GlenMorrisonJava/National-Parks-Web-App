<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<h1>Survey Results</h1>
	<p>Your vote counted and it meant a lot to us. Here are the results from other people:</p>

<table class="favoriteTable">
<tr><th></th><th>Park Name</th><th>Number of Surveys</th></tr>
<c:forEach var="favorite" items="${allFavoriteParks}">
<c:set var="parkCode" value="${favorite.parkCode}" />
<c:set var="parkCodeLowercase" value="${fn:toLowerCase(parkCode)}" />

<tr>
<td><img src="img/parks/${parkCodeLowercase}.jpg" /></td>

<td>${favorite.parkName} </td>
<td id="count">${favorite.count}</td>
</tr>


</c:forEach>
</table>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />