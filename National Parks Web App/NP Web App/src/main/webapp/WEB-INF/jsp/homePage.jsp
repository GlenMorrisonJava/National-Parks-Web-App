<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="parks">
	<c:forEach var="park" items="${allParks}">
	
	<c:url var="detailPage" value="/detailPage">
    <c:param name="parkCode">${park.parkCode} </c:param>
    </c:url>
        
	<div id="park">
	<c:set var="parkCode" value="${park.parkCode}" />
	<c:set var="parkCodeLowercase" value="${fn:toLowerCase(parkCode)}" />
		<a href="${detailPage}">
		<img src="img/parks/${parkCodeLowercase}.jpg" /> 
		</a>
		<ul class="info">
		<li id="name">${park.parkName}</li>
		<li id="description">${park.description}</li>
		</ul>
		</div>
	</c:forEach>


</div>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />