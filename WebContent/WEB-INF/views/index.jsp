<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cedar Drone</title>
<spring:url value="/resources/css/landing.css" var="landingCss"/>
<link href="${landingCss}" rel="stylesheet" />
<spring:url value="/resources/vid/flight.mp4" var="landingVideo"/>
</head>
<body>

<header></header>

    <video autoplay muted loop id="myVideo">
        <source src="${landingVideo}" type="video/mp4">
    </video>

    <div class="container">
        
        <section>
			<h1>Cedar Drone</h1>
			
			<a href="./register">Become a Member</a>
        </section>
        <section>
			<form action="./login" method="post">
				<input type="text" name="username" placeholder="User Name" />
				<input type="text" name="password" placeholder="Password" />
				<input type="submit" value="Login">
			</form>

        </section>

    </div>

<footer></footer>

<script>

    window.onload = function() {
        myFunc();
    };

    const h = document.querySelector('header');
    const f = document.querySelector('footer');

    const myFunc = () => {
        h.classList.add('reduceHeight')
        f.classList.add('reduceHeight')
    }

</script>

</body>
</html>