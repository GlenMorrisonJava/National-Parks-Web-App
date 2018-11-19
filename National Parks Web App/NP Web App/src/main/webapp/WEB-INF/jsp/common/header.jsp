<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>National Park Geek</title>
<c:url value="/css/style.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
</head>

<body>
	<header>

		<c:url value="/" var="homePageHref" />
		<c:url value="/img/logo.png" var="logoSrc" />
		<a href="${homePageHref}"> <img src="${logoSrc}" id="logo" />
		</a>

	</header>
	<nav>

		<ul>
			<c:url var="homeUrl" value="/" />
			<c:url var="surveyUrl" value="/survey" />
			<c:url var="favoritesUrl" value="/favorites"/>


			<li><a href="${homeUrl}">Home</a></li>
			<li><a href="${surveyUrl}">Survey</a></li>
			<li><a href="${favoritesUrl}">Favorite Parks</a></li>

		</ul>
	</nav>