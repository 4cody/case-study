<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cedar Drone</title>

	<spring:url value="/resources/css/styles.css" var="mainCss"/>
	<link href="${mainCss}" rel="stylesheet" />
	
</head>
<body>

<div class="landing-wrapper">
	
	<section class="landing-header"></section>

	<main class="landing-main">
	
		<section class="landing-main-section">
			
			<h1>Cedar Drone</h1>
			
			<a href="./register">Become a Member</a>
			
		</section>
		<section class="landing-main-section">
		
			<form action="./login" method="post">
				<input type="text" name="username" placeholder="User Name" />
				<input type="text" name="password" placeholder="Password" />
				<input type="submit" value="Login">
			</form>
		
		</section>
		
	</main>
	
	<section class="landing-footer"></section>

</div>

</body>
</html>