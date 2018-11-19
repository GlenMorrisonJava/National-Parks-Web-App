<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div id="surveyBody">

	<h1>Daily Survey</h1>
	<p>Vote here on your favorite national park. Be sure to fill in all
		of the required fields. Once you've completed the survey you will be
		redirected to a page where you can see your results.</p>
	<c:url value="/survey" var="surveyUrl" />
	<form:form action="${surveyUrl}" method="POST" modelAttribute="Survey">


		<div class="formBody">
		<label for="parkName">Favorite National Park</label>
			<select name="parkName">
				<c:forEach var="park" items="${allParks}">
					<option value="${park.parkCode}">${park.parkName}</option>
				</c:forEach>
			</select>
		</div>

		<div class="formBody">
			<label for="emailAddress">Email</label>
			<form:input path="emailAddress" />
			<form:errors path="emailAddress" cssClass="error" />
		</div>






		<div class="formBody">
		<label for="state">State of residence</label>
			<select name="state">
				<option value="AL">Alabama</option>
				<option value="AK">Alaska</option>
				<option value="AZ">Arizona</option>
				<option value="AR">Arkansas</option>
				<option value="CA">California</option>
				<option value="CO">Colorado</option>
				<option value="CT">Connecticut</option>
				<option value="DE">Delaware</option>
				<option value="DC">District Of Columbia</option>
				<option value="FL">Florida</option>
				<option value="GA">Georgia</option>
				<option value="HI">Hawaii</option>
				<option value="ID">Idaho</option>
				<option value="IL">Illinois</option>
				<option value="IN">Indiana</option>
				<option value="IA">Iowa</option>
				<option value="KS">Kansas</option>
				<option value="KY">Kentucky</option>
				<option value="LA">Louisiana</option>
				<option value="ME">Maine</option>
				<option value="MD">Maryland</option>
				<option value="MA">Massachusetts</option>
				<option value="MI">Michigan</option>
				<option value="MN">Minnesota</option>
				<option value="MS">Mississippi</option>
				<option value="MO">Missouri</option>
				<option value="MT">Montana</option>
				<option value="NE">Nebraska</option>
				<option value="NV">Nevada</option>
				<option value="NH">New Hampshire</option>
				<option value="NJ">New Jersey</option>
				<option value="NM">New Mexico</option>
				<option value="NY">New York</option>
				<option value="NC">North Carolina</option>
				<option value="ND">North Dakota</option>
				<option value="OH">Ohio</option>
				<option value="OK">Oklahoma</option>
				<option value="OR">Oregon</option>
				<option value="PA">Pennsylvania</option>
				<option value="RI">Rhode Island</option>
				<option value="SC">South Carolina</option>
				<option value="SD">South Dakota</option>
				<option value="TN">Tennessee</option>
				<option value="TX">Texas</option>
				<option value="UT">Utah</option>
				<option value="VT">Vermont</option>
				<option value="VA">Virginia</option>
				<option value="WA">Washington</option>
				<option value="WV">West Virginia</option>
				<option value="WI">Wisconsin</option>
				<option value="WY">Wyoming</option>
			</select>
		</div>

		<div class="formBody">
		<label for="activityLevel">Activity Level</label>
			<input type="radio" name="activityLevel" value="inactive">
			inactive <input type="radio" name="activityLevel" value="sedentary">
			sedentary <input type="radio" name="activityLevel" value="active">
			active <input type="radio" name="activityLevel"
				value="extremely active"> extremely active
			<form:errors path="activityLevel" cssClass="error" />
		</div>

		<div class="formBody">
			<input type="submit" value="Submit!" />
		</div>

	</form:form>


</div>







<c:import url="/WEB-INF/jsp/common/footer.jsp" />